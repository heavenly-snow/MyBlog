package com.sunshinerao.myblog.service.impl;

import com.sunshinerao.myblog.dto.ArticleCreateDTO;
import com.sunshinerao.myblog.dto.ArticleUpdateDTO;
import com.sunshinerao.myblog.entity.Article;
import com.sunshinerao.myblog.mapper.ArticleMapper;
import com.sunshinerao.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Article getArticleById(Long id) {
        return articleMapper.findById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.findAll();
    }

//往上为查询方法--------------------------------------------------------------------------------

    @Override
    public Article createArticle(ArticleCreateDTO articleDTO) {
        Article article = new Article();
        article.setTitle(articleDTO.getTitle());
        article.setContent(articleDTO.getContent());
        article.setCreateTime(LocalDateTime.now());

        // MyBatis 插入完成后对象已经包含了数据库生成的ID。
        articleMapper.insert(article);

        return article;
    }


    @Override
    public Article updateArticle(Long id, ArticleUpdateDTO articleDTO) {
        // 1. 先根据ID查出旧的文章
        Article existingArticle = articleMapper.findById(id);

        // 2. 如果文章存在，则更新内容
        if (existingArticle != null) {
            existingArticle.setTitle(articleDTO.getTitle());
            existingArticle.setContent(articleDTO.getContent());
            articleMapper.update(existingArticle);
            return existingArticle;
        }

        // 3. 如果文章不存在，返回null
        return null;
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteById(id);
    }
}