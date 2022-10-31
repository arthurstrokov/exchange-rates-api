package com.gmail.arthurstrokov.exchangeratesapi.controllers;

import com.gmail.arthurstrokov.exchangeratesapi.gateway.ExchangeRatesFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 31.10.2022
 */
@RequiredArgsConstructor
@RestController
public class ExchangeRatesController {

    private final ExchangeRatesFeignClient exchangeRatesFeignClient;

    @GetMapping("/currencies")
    public String getAllExchangeRates() {
        return exchangeRatesFeignClient.getCurrencies();
    }

    @GetMapping("/currencies/{cur_id}")
    public String getExchangeRates(@PathVariable String cur_id) {
        return exchangeRatesFeignClient.getCurrency(cur_id);
    }

    @GetMapping("/rates")
    public String getRates(@RequestParam(value = "periodicity", defaultValue = "0") String periodicity) {
        return exchangeRatesFeignClient.getRates(periodicity);
    }
}
