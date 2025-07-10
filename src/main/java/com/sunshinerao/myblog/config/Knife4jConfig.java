package com.sunshinerao.myblog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("我的个人博客 API 文档") // 文档标题
                        .version("1.0") // 文档版本
                        .description("这是一个使用Spring Boot和MyBatis构建的博客API") // 文档描述
                );
    }
}