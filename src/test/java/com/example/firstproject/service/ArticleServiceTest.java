package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅된다.
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    // < 글 목록 확인 함수 테스트>
    @Test
    void index() {
        // 예상 (DB 안에 들어있는 예상 데이터들)
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 실제 (DB 안에 들어있는 실제 데이터들)
        List<Article> articles = articleService.index();

        // 비교 (DB 안에 들어있는 예상 데이터들과 DB 안에 들어있는 실제 데이터들이 서로 값이 같은지 비교한다.)
        assertEquals(expected.toString(), articles.toString());

    }

    // < 특정 글 목록 확인 함수 테스트>
    @Test
    void show_성공____존재하는_id_입력() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");

        // 실제
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패____존재하지_않는_id_입력() {
        // 예상
        Long id = -1L;
        Article expected = null;

        // 실제
        Article article = articleService.show(id);

        // 비교 (null 값은 서로 값을 비교할 수 없기 때문에 toString() 메소드를 사용할 수 없다.)
        assertEquals(expected, article);
    }

    // < 글 생성 함수 테스트 >
    @Test
    @Transactional
    void create_성공____title과_content만_있는_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content); // 값을 입력 시 dto가 이렇게 나온다.
        Article expected = new Article(4L, title, content); // dto 를 service 에 집어넣으면 다음과 같이 나온다고 예상함

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패____id가_포함된_dto_입력() {
        // 예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        // 실제
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);
    }

    // ------------------------------------------------------------------------
    // < 테스트 자율과제 >

//    @Test
//    @Transactional
//    void update_성공____존재하는_id와_title_content가_있는_dto_입력() {
//
//        // 예상
//        Long id = 3L;
//        String title = "다다다다asdsa";
//        String content = "3333";
//        ArticleForm dto = new ArticleForm(id, title, content);
//        Article expected = new Article(id, title, content);
//
//        // 실제
//        Article article = articleService.update(3L, dto);
//
//        // 비교
//        assertEquals(expected.toString(), article.toString());
//    }
//
//    @Test
//    @Transactional
//    void update_성공____존재하는_id와_title만_있는_dto_입력(){
//        // 예상
//        Long id = 1L;
//        String title = "blahblah";
//        ArticleForm dto= new ArticleForm(id, title, null);
//
//        // 예상
//        Article expected = new Article(id, title, "1111");
//
//        // 실제
//        Article article = articleService.update(1L, dto);
//
//        // 비교
//        assertEquals(expected.toString(), article.toString());
//    }
//
//    @Test
//    @Transactional
//    void update_실패____존재하지_않는_id의_dto_입력() {
//        Long id = 4L;
//        String title = "sadkna";
//        String content = "snsflnk";
//        ArticleForm dto = new ArticleForm(4L, "sadkna", "snsflnk");
//
//        // 예상
//        Article expected = new Article();
//
//        // 실제
//        Article article = articleService.update(4L, dto);
//
//    }
//
//    @Test
//    @Transactional
//    void update_실패____id만_있는_dto_입력() {
//    }
//
//    @Test
//    void delete_성공____존재하는_id_입력() {
//    }
//
//    @Test
//    void delete_실패____존재하지_않는_id_입력() {
//    }
}