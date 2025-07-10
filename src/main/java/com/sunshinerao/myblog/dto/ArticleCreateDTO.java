package com.sunshinerao.myblog.dto;

import lombok.Data;

/**
 * 创建文章时使用的数据传输对象 (DTO)
 */
@Data
public class ArticleCreateDTO {

    // 只包含客户端应该提供的字段
    private String title;
    private String content;

}