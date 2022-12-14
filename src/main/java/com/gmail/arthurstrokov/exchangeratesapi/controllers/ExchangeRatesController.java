package com.gmail.arthurstrokov.exchangeratesapi.controllers;

import com.gmail.arthurstrokov.exchangeratesapi.gateway.ExchangeRatesFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.*;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 31.10.2022
 */
@RequiredArgsConstructor
@RestController
public class ExchangeRatesController {

    private final ExchangeRatesFeignClient exchangeRatesFeignClient;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/currencies")
    public String getAllCurrencies() {
        return exchangeRatesFeignClient.getCurrencies();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/currencies/{cur_id}")
    public String getCurrency(@PathVariable("cur_id") String currentId) {
        return exchangeRatesFeignClient.getCurrency(currentId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/rates")
    public String getAllRates(@RequestParam(value = "periodicity", defaultValue = "0") String periodicity) {
        return exchangeRatesFeignClient.getAllRates(periodicity);
    }

    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 5000))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/rates/{cur_id}")
    public String getRates(
            @PathVariable("cur_id") String currentId,
            @RequestParam(value = "ondate", required = false) String ondate,
            @RequestParam(value = "periodicity", defaultValue = "0") String periodicity) {
        return exchangeRatesFeignClient.getRates(currentId, ondate, periodicity);
    }
}
