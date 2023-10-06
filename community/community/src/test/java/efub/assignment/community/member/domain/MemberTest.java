package efub.assignment.community.member.domain;

import efub.assignment.community.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional(readOnly = true)
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    public void 멤버_등록_성공() {
        // given
        String email = "efub10@gmail.com";
        String password = "efub10!";
        String nickname = "퍼비10";
        String university = "이화여자대학교";
        String studentId = "2071010";
        String bio = "안녕하세요!";

        // when
        Member member = new Member(email, password, nickname, university, studentId, bio);
        memberRepository.save(member);

        // then
        Member savedMember = memberRepository.findMemberByEmail("efub10@gmail.com");
        assertThat(savedMember.getEmail()).isEqualTo(email);
        assertThat(savedMember.getNickname()).isEqualTo(nickname);
        assertThat(savedMember.getUniversity()).isEqualTo(university);
        assertThat(savedMember.getStudentId()).isEqualTo(studentId);
    }
}