package efub.assignment.community.messageroom.controller;

import efub.assignment.community.member.service.MemberService;
import efub.assignment.community.messageroom.domain.MessageRoom;
import efub.assignment.community.messageroom.dto.MessageRoomExistsRequestDto;
import efub.assignment.community.messageroom.dto.MessageRoomRequestDto;
import efub.assignment.community.messageroom.dto.MessageRoomResponseDto;
import efub.assignment.community.messageroom.service.MessageRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/messagerooms")
@RequiredArgsConstructor
public class MessageRoomController {
    public final MessageRoomService messageRoomService;
    public final MemberService memberService;

    // 쪽지방 생성
    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public MessageRoomResponseDto messageRoomCreate(@RequestBody MessageRoomRequestDto requestDto) {
        MessageRoom messageRoom = messageRoomService.createMessageRoom(requestDto);
        return new MessageRoomResponseDto(messageRoom);
    }

    // 쪽지방 여부 조회
    @GetMapping("/exists")
    @ResponseStatus(value = HttpStatus.OK)
    public Long messageRoomExists(@RequestBody MessageRoomExistsRequestDto requestDto) {
        MessageRoom messageRoom = messageRoomService.existsMessageRoom(requestDto);
        Long messageRoomId = messageRoom.getMessageRoomId();
        return messageRoomId;
    }

    // 쪽지방 목록 조회
}
