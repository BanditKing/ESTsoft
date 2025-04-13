package com.estsoft.demo.blog.repository;

import com.estsoft.demo.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();
}
