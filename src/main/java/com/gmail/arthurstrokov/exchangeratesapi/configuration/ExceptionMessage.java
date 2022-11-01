package com.gmail.arthurstrokov.exchangeratesapi.configuration;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 01.11.2022
 */
@Data
@Getter
@Setter
@ToString
public class ExceptionMessage {
    private String timestamp;
    private int status;
    private String reason;
}
