package com.sunshinerao.myblog.controller;

import com.sunshinerao.myblog.dto.ArticleCreateDTO;
import com.sunshinerao.myblog.dto.ArticleUpdateDTO;
import com.sunshinerao.myblog.entity.Article;
import com.sunshinerao.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章相关的API接口
 */
@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据ID获取文章
     * @param id 文章ID
     * @return 包含文章数据的ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 获取所有文章的列表
     * @return 包含文章列表的ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    /**
     * 创建一篇新文章
     * @param articleDTO 从请求体中获取的文章创建数据 (JSON格式)
     * @return 包含创建成功后完整信息的文章数据
     */
    @PostMapping
    public ResponseEntity<Object> createArticle(@RequestBody ArticleCreateDTO articleDTO) {
        // 将接收到的DTO对象传递给Service层进行处理
        Article createdArticle = articleService.createArticle(articleDTO);
        if (createdArticle.getId() != null) {
            return ResponseEntity.ok(createdArticle);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("插入操作失败，服务器内部错误");
        }
    }

    /**
     * 更新一篇文章
     * @param id 要更新的文章ID
     * @param articleDTO 包含新标题和新内容的数据
     * @return 更新后的文章对象
     */
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody ArticleUpdateDTO articleDTO) {
        Article updatedArticle = articleService.updateArticle(id, articleDTO);
        if (updatedArticle != null) {
            return ResponseEntity.ok(updatedArticle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 根据ID删除一篇文章
     * @param id 要删除的文章ID
     * @return 204 No Content表示成功
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        // 对于删除操作，成功后返回 204 No Content 是最佳实践
        return ResponseEntity.noContent().build();
    }
}