package efub.assignment.community.post.domain;

import efub.assignment.community.account.domain.Member;
import efub.assignment.community.board.domain.Board;
import efub.assignment.community.global.entity.BaseTimeEntity;
import efub.assignment.community.post.dto.PostModifyRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column
    private String selectDisplayAuthor;

    @Column
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @Builder
    public Post(Long postId, Board board, String selectDisplayAuthor, String title, String content, Member writer) {
        this.postId = postId;
        this.board = board;
        this.selectDisplayAuthor = selectDisplayAuthor;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void updatePost(PostModifyRequestDto requestDto) {
        this.selectDisplayAuthor = requestDto.getSelectDisplayAuthor();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}
