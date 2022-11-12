package com.gmail.arthurstrokov.exchangeratesapi.gateway;

import com.gmail.arthurstrokov.exchangeratesapi.configuration.FeignSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 31.10.2022
 */
@FeignClient(name = "exchange-rates", url = "https://www.nbrb.by/api/exrates", configuration = {FeignSupportConfig.class})
public interface ExchangeRatesFeignClient {

    @GetMapping("/currencies")
    String getCurrencies();

    @GetMapping("/currencies/{cur_id}")
    String getCurrency(@PathVariable("cur_id") String currentId);

    @GetMapping("/rates")
    String getAllRates(@RequestParam("periodicity") String periodicity);

    @GetMapping("/rates/{cur_id}")
    String getRates(
            @PathVariable("cur_id") String currentId,
            @RequestParam("ondate") String onDate,
            @RequestParam("periodicity") String periodicity
    );
}
