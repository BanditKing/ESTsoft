package com.estsoft.demo.blog.controller;

import com.estsoft.demo.blog.entity.Article;
import com.estsoft.demo.blog.dto.AddArticleRequest;
import com.estsoft.demo.blog.dto.ArticleResponse;
import com.estsoft.demo.blog.dto.UpdateArticleRequest;
import com.estsoft.demo.blog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static java.util.Arrays.stream;

@RestController
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    //POST / api/articles
    //{ title:"", content: "" }

    @PostMapping("/api/articles")
    public ResponseEntity<ArticleResponse> saveArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.saveArticle(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(savedArticle.toDto());
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findArticles() {
        List<Article> articles = blogService.findArticles();

        List<ArticleResponse> responseBody = articles.stream().map(article ->
                new ArticleResponse(article.getId(), article.getTitle(), article.getContent()))
                .toList();

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable Long id) {
        Article article = blogService.findArticleById(id);
        return ResponseEntity.ok(article.toDto());
    }

    // DELETE /api/articles/{id}    /api/articles/1
    @DeleteMapping("/api/articles/{id}")
    //@RequestMapping(method = RequestMethod.DELETE) 위에 어노테이션과 같다.
    public ResponseEntity<Void>//리턴타입보이드
    deleteArticle(@PathVariable Long id) {
        blogService.deleteArticleById(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> updateArticle(@PathVariable("id") Long id , @RequestBody UpdateArticleRequest request) {

        Article article = blogService.updateArticle(id, request);
        ArticleResponse response = article.toDto();
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException e) {
        return e.getMessage();
    }
}
