package com.gmail.arthurstrokov.exchangeratesapi.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.arthurstrokov.exchangeratesapi.configuration.ExceptionMessage;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 01.11.2022
 */
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @SneakyThrows
    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = new ExceptionMessage();
        message.setStatus(response.status());
        message.setReason(response.reason());

        ObjectMapper objectMapper = new ObjectMapper();
        String errorMessage = objectMapper.writeValueAsString(message);

        return switch (response.status()) {
            case 400 -> new BadRequestException(errorMessage);
            case 404 -> new NotFoundException(errorMessage);
            case 500 ->
                    new RetryableException(500, response.reason(), response.request().httpMethod(), null, response.request());
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
