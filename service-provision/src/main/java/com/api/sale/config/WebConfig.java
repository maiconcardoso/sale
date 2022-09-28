package com.api.sale.config;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class WebConfig {
    
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
        List<String> allUrls = Arrays.asList("*");

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(allUrls);
        corsConfiguration.setAllowedHeaders(allUrls);
        corsConfiguration.setAllowedMethods(allUrls);
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        CorsFilter corsFilter = new CorsFilter();
        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(corsFilter);
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filter;


    }
}
