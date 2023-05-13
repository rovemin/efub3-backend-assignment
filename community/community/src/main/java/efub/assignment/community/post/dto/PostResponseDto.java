package efub.assignment.community.post.dto;

import efub.assignment.community.post.domain.Post;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDto {
    private Long postId;
    private String boardName;
    private String writerName;
    private Boolean isPrivate;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PostResponseDto(Long postId, String boardName, String writerName, Boolean isPrivate,
                           String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.postId = postId;
        this.boardName = boardName;
        this.writerName = writerName;
        this.isPrivate = isPrivate;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static PostResponseDto from(Post post) {
        return new PostResponseDto(
                post.getPostId(),
                post.getBoard().getBoardName(),
                post.getWriter().getNickname(),
                post.getIsPrivate(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedDate(),
                post.getModifiedDate());
    }
}
