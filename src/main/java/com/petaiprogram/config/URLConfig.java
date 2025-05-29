package com.petaiprogram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/05/17  22:06
 */
@Configuration
public class URLConfig {
    @Value("${baseURL}")
    private String baseURL;

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }
}
