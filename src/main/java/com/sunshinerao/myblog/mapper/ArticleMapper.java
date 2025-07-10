package com.sunshinerao.myblog.mapper;

import com.sunshinerao.myblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 根据ID查找文章
     * @param id 文章ID
     * @return 找到的文章对象
     */
    Article findById(Long id);

    /**
     * 插入一篇新文章。
     * 注意：此方法会产生一个副作用。由于XML中配置了useGeneratedKeys和keyProperty，
     * 执行完毕后，传入的article对象的id字段将会被填充为数据库新生成的自增ID。
     * @param article 要插入的文章对象
     */
    void insert(Article article);

    /**
     * 获取所有文章列表
     * @return 文章对象列表
     */
    List<Article> findAll();

    /**
     * 更新文章
     * @param article
     * @return
     */
    int update(Article article);

    int deleteById(Long id);
}