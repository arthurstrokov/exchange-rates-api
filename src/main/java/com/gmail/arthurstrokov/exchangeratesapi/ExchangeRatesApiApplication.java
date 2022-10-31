package com.gmail.arthurstrokov.exchangeratesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ExchangeRatesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRatesApiApplication.class, args);
    }
}
