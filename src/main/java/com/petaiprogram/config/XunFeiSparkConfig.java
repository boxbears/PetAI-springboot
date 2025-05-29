package com.petaiprogram.config;

import io.github.briqt.spark4j.SparkClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/05/16  16:12
 */
@Configuration
@ConfigurationProperties(prefix = "xunfei.client")
@Data
public class XunFeiSparkConfig {

    private String appid;
    private String apiSecret;
    private String apiKey;

    @Bean
    public SparkClient sparkClient() {
        SparkClient sparkClient = new SparkClient();
        sparkClient.apiKey = apiKey;
        sparkClient.apiSecret = apiSecret;
        sparkClient.appid = appid;
        return sparkClient;
    }
}

