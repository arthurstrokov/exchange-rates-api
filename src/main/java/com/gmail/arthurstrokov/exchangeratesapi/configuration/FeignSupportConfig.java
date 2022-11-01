package com.gmail.arthurstrokov.exchangeratesapi.configuration;

import com.gmail.arthurstrokov.exchangeratesapi.exceptions.RetreiveMessageErrorDecoder;
import feign.Retryer;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 01.11.2022
 */
public class FeignSupportConfig {

    @Bean
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(() -> new HttpMessageConverters(new RestTemplate().getMessageConverters())));
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetreiveMessageErrorDecoder();
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 3);
    }
}
