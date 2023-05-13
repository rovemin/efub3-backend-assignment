package efub.assignment.community.comment.controller;

import efub.assignment.community.board.domain.Board;
import efub.assignment.community.board.dto.BoardRequestDto;
import efub.assignment.community.board.dto.BoardResponseDto;
import efub.assignment.community.comment.domain.Comment;
import efub.assignment.community.comment.dto.CommentModifyRequestDto;
import efub.assignment.community.comment.dto.CommentRequestDto;
import efub.assignment.community.comment.dto.CommentResponseDto;
import efub.assignment.community.comment.service.CommentService;
import efub.assignment.community.member.domain.Member;
import efub.assignment.community.post.domain.Post;
import efub.assignment.community.post.dto.PostModifyRequestDto;
import efub.assignment.community.post.dto.PostRequestDto;
import efub.assignment.community.post.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor    // 생성자를 통한 의존관계 주입
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    // 댓글 수정
    @PutMapping("/{commentId}")
    @ResponseStatus(value = HttpStatus.OK)
    public CommentResponseDto commentModify(@PathVariable Long commentId, @RequestBody CommentModifyRequestDto requestDto) {
        Comment comment = commentService.modifyComment(commentId, requestDto);
        return CommentResponseDto.of(comment);
    }
    
    // 댓글 삭제
}
