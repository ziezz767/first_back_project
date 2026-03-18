package com.example.firstproject.api;

import com.example.firstproject.annotation.RunningTime;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    // 댓글 목록 조회
    @GetMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        // 서비스에게 위임(밑에 body 부분에 넣어서 결과를 확인시켜주기 위해서 만든거나 다름없음)
        List<CommentDto> dtos = commentService.comments(articleId);

        // 결과 응답(무조건 성공했다는 가정하에 한 결과이다. 예외 발생 시, 서비스에서 의도적으로 예외를 발생시킨다. 해당 메소드는 예외 발생을 하지는 않음)
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    // 댓글 생성
    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,@RequestBody CommentDto dto) {
        // 서비스에게 위임
        CommentDto createdDto = commentService.create(articleId, dto); //
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    // 댓글 수정
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id,
                                             @RequestBody CommentDto dto) {
        // 서비스에게 위임
        CommentDto updatedDto = commentService.update(id, dto); // 댓글을 엔티티로 만들고 리파지터리로 DB에 저장한다음 결과를 응답해주기 위해서 DTO로 다시 변환하여 가져온다.
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    // 댓글 삭제
    @RunningTime
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        // 서비스에게 위임
        CommentDto updatedDto = commentService.delete(id); // 댓글을 엔티티로 만들고 리파지터리로 DB에 저장한다음 결과를 응답해주기 위해서 DTO로 다시 변환하여 가져온다.
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

}
