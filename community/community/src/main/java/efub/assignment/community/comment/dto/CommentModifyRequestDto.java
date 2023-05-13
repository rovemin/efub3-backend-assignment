package efub.assignment.community.comment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentModifyRequestDto {
    private Long commentId;
    private Long memberId;
    private String content;
}
