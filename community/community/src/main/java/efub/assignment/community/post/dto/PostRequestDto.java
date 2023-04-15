package efub.assignment.community.post.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostRequestDto {
    private Long boardId;
    private Long memberId;
    private String selectDisplayAuthor;
    private String title;
    private String content;
}
