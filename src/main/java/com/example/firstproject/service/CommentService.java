package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    // < 댓글 조회 >
    public List<CommentDto> comments(Long articleId) {
        // 반환
        return commentRepository.findByArticleId(articleId) // 조회: 댓글 목록
                .stream() // 변환: 엔티티 -> DTO
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    //< DTO 댓글을 엔티티 댓글로 생성해주는 메소드>
    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // 로깅 Parameters 값


        // 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! 대상 게시글이 없습니다.")); // 만약에 값이 없다면 예외를 발생시키겠다.

        // 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto,article);

        // 댓글 엔티티를 DB로 저장 (** 애가 문제라고 뜹니다 ㅠㅠ**)
        Comment created = commentRepository.save(comment);

        // DTO로 변경하여 변환
        return CommentDto.createCommentDto(created);

        // 로깅 Return Value 값

    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // 댓글 조회 및 예외 발생
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 수정 실패! 대상 댓글이 없습니다."));

        // 댓글 수정
        target.patch(dto);

        // DB로 갱신
        Comment updated = commentRepository.save(target);

        // 댓글 엔티티를 DTO로 변환 및 반환
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        // 댓글 조회(및 예외 발생)
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("댓글 삭제 실패! 대상이 없습니다."));

        // 댓글 DB에서 삭제
        commentRepository.delete(target);

        // 삭제 댓글을 DTO로 변환
        return CommentDto.createCommentDto(target);
    }
}
