package com.gmail.arthurstrokov.exchangeratesapi.gateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 31.10.2022
 */
@FeignClient(name = "exchange-rates", url = "https://www.nbrb.by/api/exrates")
public interface ExchangeRatesFeignClient {

    @GetMapping("/currencies")
    String getCurrencies();

    @GetMapping("/currencies/{cur_id}")
    String getCurrency(@PathVariable("cur_id") String cur_id);

    @GetMapping("/rates")
    String getRates(@RequestParam("periodicity") String periodicity);
}