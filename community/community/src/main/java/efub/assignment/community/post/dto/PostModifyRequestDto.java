package efub.assignment.community.post.dto;

import lombok.Getter;

@Getter
public class PostModifyRequestDto {
    private Long boardId;
    private Long memberId;
    private String selectDisplayAuthor;
    private String title;
    private String content;
}
