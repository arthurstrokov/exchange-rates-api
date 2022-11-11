package com.gmail.arthurstrokov.exchangeratesapi.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.arthurstrokov.exchangeratesapi.model.Rate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 11.11.2022
 */
@Component
@RequiredArgsConstructor
public class RateMapper {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public String toJson(Rate rate) {
        return objectMapper.writeValueAsString(rate);
    }

    @SneakyThrows
    public Rate toRate(String rate) {
        return objectMapper.readValue(rate, Rate.class);
    }

    @SneakyThrows
    public Rate[] toRates(String rates) {
        return objectMapper.readValue(rates, Rate[].class);
    }
}
