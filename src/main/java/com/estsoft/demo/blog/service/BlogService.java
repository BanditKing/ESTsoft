package com.estsoft.demo.blog.service;

import com.estsoft.demo.blog.entity.Article;
import com.estsoft.demo.blog.dto.AddArticleRequest;
import com.estsoft.demo.blog.dto.UpdateArticleRequest;
import com.estsoft.demo.blog.repository.BlogRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {

        this.blogRepository = blogRepository;
    }

    public Article saveArticle(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findArticles() {
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }


    public Article findArticleById(Long id){
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
    }
    public void deleteArticleById(Long id){
        blogRepository.deleteById(id); // delete from article where id = ${id}
    }
    @Transactional
    public Article updateArticle(Long id , UpdateArticleRequest request){
        //findById (수정하기 이전 Article 객체)
        Article beforeArticle = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not exists id: " + id)); // 아이디 값에 해당 값이 없으면 500 error

        // update
        beforeArticle.update(request.getTitle(), request.getContent());
        return beforeArticle;
    }


}
