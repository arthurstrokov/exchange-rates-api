package com.gmail.arthurstrokov.exchangeratesapi.exceptions;

import com.gmail.arthurstrokov.exchangeratesapi.configuration.ExceptionMessage;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.time.LocalDateTime;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 01.11.2022
 */
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = new ExceptionMessage();
        message.setTimestamp(String.valueOf(LocalDateTime.now()));
        message.setStatus(response.status());
        message.setReason(response.reason());

        return switch (response.status()) {
            case 400 -> new BadRequestException(message.getReason() != null ? message.getReason() : "Bad Request");
            case 404 -> new NotFoundException(message.getReason() != null ? message.getReason() : "Not found");
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
