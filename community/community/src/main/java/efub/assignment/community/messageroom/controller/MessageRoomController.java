package efub.assignment.community.messageroom.controller;

import efub.assignment.community.board.domain.Board;
import efub.assignment.community.board.dto.BoardResponseDto;
import efub.assignment.community.member.domain.Member;
import efub.assignment.community.member.service.MemberService;
import efub.assignment.community.messageroom.domain.MessageRoom;
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

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public MessageRoomResponseDto messageRoomCreate(@RequestBody MessageRoomRequestDto requestDto) {
        MessageRoom messageRoom = messageRoomService.createMessageRoom(requestDto);
        return new MessageRoomResponseDto(messageRoom);
    }
}
