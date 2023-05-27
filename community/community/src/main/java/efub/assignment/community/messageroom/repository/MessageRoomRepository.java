package efub.assignment.community.messageroom.repository;

import efub.assignment.community.member.domain.Member;
import efub.assignment.community.messageroom.domain.MessageRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRoomRepository extends JpaRepository<MessageRoom, Long> {
    Boolean existsBySenderAndReceiver(Member sender, Member receiver);
}
