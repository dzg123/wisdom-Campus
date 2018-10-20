package com.dzg.springarcgis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCommonConfig {
    @Bean
    public MyEndpointConfigure myEndpointConfigure() {
        return new MyEndpointConfigure();
    }
}
