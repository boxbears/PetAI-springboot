package com.petaiprogram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/02/07  16:37
 */
@Configuration
public class ChatGPTConfig {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    @Value("${openai.api.url}")
    private String openaiApiUrl;

    @Value("${proxy.enabled}")
    private boolean proxyEnabled;

    @Value("${proxy.host}")
    private String proxyHost;

    @Value("${proxy.port}")
    private int proxyPort;

    // Getters and Setters

    public String getOpenaiApiKey() {
        return openaiApiKey;
    }

    public String getOpenaiApiUrl() {
        return openaiApiUrl;
    }

    public boolean isProxyEnabled() {
        return proxyEnabled;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }
}
