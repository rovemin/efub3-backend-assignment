package efub.assignment.community.heart.service;

import efub.assignment.community.comment.domain.Comment;
import efub.assignment.community.comment.service.CommentService;
import efub.assignment.community.heart.domain.CommentHeart;
import efub.assignment.community.heart.repository.CommentHeartRepository;
import efub.assignment.community.member.domain.Member;
import efub.assignment.community.member.dto.MemberInfoRequestDto;
import efub.assignment.community.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentHeartService {
    private final CommentService commentService;
    private final CommentHeartRepository commentHeartRepository;

    private final MemberService memberService;

    public void create(Long commentId, MemberInfoRequestDto requestDto) {
        Member member = memberService.findMemberById(requestDto.getMemberId());
        Comment comment = commentService.findCommentById(commentId);

        if (isExistsByWriterAndComment(member, comment)) {
            throw new RuntimeException("이미 좋아요를 눌렀습니다.");
        }

        CommentHeart commentHeart = CommentHeart.builder()
                .comment(comment)
                .member(member)
                .build();

        commentHeartRepository.save(commentHeart);
    }

    public void delete(Long commentId, Long memberId) {
        Member member = memberService.findMemberById(memberId);
        Comment comment = commentService.findCommentById(commentId);

        CommentHeart commentHeart = commentHeartRepository.findByWriterAndComment(member, comment)
                .orElseThrow(() -> new IllegalArgumentException("해당 좋아요가 없습니다."));
        commentHeartRepository.delete(commentHeart);
    }

    @Transactional(readOnly = true)
    public boolean isExistsByWriterAndComment(Member member, Comment comment) {
        return commentHeartRepository.existsByWriterAndComment(member, comment);
    }

    @Transactional(readOnly = true)
    public Integer countCommentHeart(Comment comment) {
        Integer count = commentHeartRepository.countByComment(comment);
        return count;
    }
}
