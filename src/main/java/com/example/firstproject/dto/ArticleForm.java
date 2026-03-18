package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    // toEntity 함수의 반환값인 Article(entity) 를 잘 봐라
    public Article toEntity() {
        return new Article(id, title, content);
    }
}
