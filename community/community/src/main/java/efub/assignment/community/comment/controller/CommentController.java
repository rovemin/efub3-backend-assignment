package efub.assignment.community.comment.controller;

import efub.assignment.community.comment.domain.Comment;
import efub.assignment.community.comment.dto.CommentRequestDto;
import efub.assignment.community.comment.dto.CommentResponseDto;
import efub.assignment.community.comment.service.CommentService;
import efub.assignment.community.heart.dto.HeartRequestDto;
import efub.assignment.community.heart.service.CommentHeartService;
import efub.assignment.community.member.dto.MemberInfoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor    // 생성자를 통한 의존관계 주입
@RequestMapping("/comments/{commentId}")
public class CommentController {
    private final CommentService commentService;
    private final CommentHeartService commentHeartService;

    // 댓글 수정
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CommentResponseDto updatePostComment(@PathVariable final Long commentId, @RequestBody @Valid final CommentRequestDto requestDto) {
        commentService.updateComment(requestDto, commentId);
        Comment comment = commentService.findCommentById(commentId);
        return CommentResponseDto.of(comment);
    }
    
    // 댓글 삭제
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteComment(@PathVariable final Long commentId) {
        commentService.deleteComment(commentId);
        return "성공적으로 삭제되었습니다.";
    }

    // 댓글 좋아요
    @PostMapping("/hearts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createCommentHeart(@PathVariable final Long commentId, @RequestBody final MemberInfoRequestDto requestDto) {
        commentHeartService.create(commentId, requestDto);
        return "좋아요를 눌렀습니다.";
    }

    // 댓글 좋아요 취소
    @DeleteMapping("/hearts")
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteCommentHeart(@PathVariable final Long commentId, @RequestParam final Long memberId) {
        commentHeartService.delete(commentId, memberId);
        return "좋아요가 취소되었습니다.";
    }
}
