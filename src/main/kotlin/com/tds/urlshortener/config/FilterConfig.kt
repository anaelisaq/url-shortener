package com.tds.urlshortener.config

import com.tds.urlshortener.util.filter.UrlAccessFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FilterConfig {
    @Bean
    fun urlAccessFilterRegistration(urlAccessFilter: UrlAccessFilter): FilterRegistrationBean<UrlAccessFilter>{
        val registration = FilterRegistrationBean(urlAccessFilter)
        registration.addUrlPatterns("/api/url-shortener/shorten")
        return registration
    }
}