package com.sunshinerao.myblog;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunshinerao.myblog.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class MyBlogApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // 配置支持 Java 8 日期时间
        mapper.findAndRegisterModules();

        Article article = new Article(
                1L,
                "测试文章",
                "这是内容",
                LocalDateTime.now()
        );

        String json = mapper.writeValueAsString(article);
        System.out.println(json);
    }

}
