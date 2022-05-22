/*
 * @(#)WebConfig.java
 *
 * Copyright (c) BANCO DE CHILE (Chile). All rights reserved.
 *
 * All rights to this product are owned by BANCO DE CHILE and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BANCO DE CHILE.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package com.amaris.driveracademy.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig.
 *
 * @author Camilo Valderrama.
 * @version 1.0.0, 21-05-2022
 */
@EnableAutoConfiguration
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(),
                HttpMethod.DELETE.name(), HttpMethod.PUT.name());
    }
}