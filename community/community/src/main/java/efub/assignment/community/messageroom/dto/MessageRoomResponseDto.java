package efub.assignment.community.messageroom.dto;

import efub.assignment.community.messageroom.domain.MessageRoom;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageRoomResponseDto {
    private Long messageRoomId;
    private Long sender;
    private Long receiver;
    private String firstMessage;
    private Long postId;
    private LocalDateTime createdDate;

    public MessageRoomResponseDto(MessageRoom messageRoom) {
        this.messageRoomId = messageRoom.getMessageRoomId();
        this.sender = messageRoom.getSender().getMemberId();
        this.receiver = messageRoom.getReceiver().getMemberId();
        this.firstMessage = messageRoom.getFirstMessage();
        this.postId = messageRoom.getPost().getPostId();
        this.createdDate = messageRoom.getCreatedDate();
    }
}
