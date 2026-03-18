package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll(); // 기본적으로 findAll() 함수는 Iterable<Article> 형으로 반환해주는데 이걸 ArrayList<Article> 형태로 반환하도록 바꿔준다.
}
