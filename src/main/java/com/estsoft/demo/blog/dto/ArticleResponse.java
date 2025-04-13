package com.estsoft.demo.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ArticleResponse {
    private Long id;
    private String title;
    private String content;
}
