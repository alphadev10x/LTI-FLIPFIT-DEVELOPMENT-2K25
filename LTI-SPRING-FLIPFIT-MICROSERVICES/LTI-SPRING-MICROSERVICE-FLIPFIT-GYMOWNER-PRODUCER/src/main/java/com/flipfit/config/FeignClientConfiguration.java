package com.flipfit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flipfit.exception.CustomFeignErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FeignClientConfiguration {
	
	@Bean
    public ErrorDecoder customFeignErrorDecoder() {
        return new CustomFeignErrorDecoder();
    }

}
