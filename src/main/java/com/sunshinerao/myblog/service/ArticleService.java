package com.sunshinerao.myblog.service;

import com.sunshinerao.myblog.dto.ArticleCreateDTO;
import com.sunshinerao.myblog.dto.ArticleUpdateDTO;
import com.sunshinerao.myblog.entity.Article;

import java.util.List;

/**
 * 文章服务接口
 */
public interface ArticleService {

    /**
     * 根据ID获取文章详情
     *
     * @param id 文章ID
     * @return 找到的文章对象，如果不存在则返回null
     */
    Article getArticleById(Long id);

    /**
     * 获取所有文章
     * @return
     */
    List<Article> getAllArticles();
//往上为查询方法-------------------------------------------------------------------------------------------

    /**
     * 创建一篇新文章
     *
     * @param articleDTO 包含文章标题和内容的数据传输对象
     * @return 创建成功后，包含了新ID和创建时间的完整文章对象
     */
    Article createArticle(ArticleCreateDTO articleDTO);

//往上为创建方法--------------------------------------------------------------------------------

    Article updateArticle(Long id, ArticleUpdateDTO articleDTO);

    void deleteArticle(Long id);
}