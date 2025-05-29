package com.petaiprogram.config;

/**
 * 功能描述
 *
 * @author 27609
 * @date 2024/02/28  23:46
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 指定文件上传后保存的目录
        String uploadDir = "src/main/resources/static/";

        // 添加静态资源处理器，将指定目录下的文件暴露为静态资源
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadDir);
    }
}