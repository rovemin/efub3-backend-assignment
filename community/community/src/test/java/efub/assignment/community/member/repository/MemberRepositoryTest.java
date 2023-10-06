package efub.assignment.community.member.repository;

import efub.assignment.community.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional(readOnly = true)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    public void 이메일로_멤버_조회() throws Exception {
        // given
        Member member = new Member("efub10@gmail.com", "efub10!", "퍼비10", "이화여자대학교", "2071010", "안녕하세요!");

        // when
        memberRepository.save(member);

        // then
        assertThat(member).isEqualTo(memberRepository.findMemberByEmail("efub10@gmail.com"));
    }

    @Test
    @Transactional
    public void 멤버_존재_여부_이메일로_확인() throws Exception {
        // given
        Member member = new Member("efub10@gmail.com", "efub10!", "퍼비10", "이화여자대학교", "2071010", "안녕하세요!");
        memberRepository.save(member);

        // when
        String email = member.getEmail();

        // then
        assertThat(memberRepository.existsByEmail(email)).isNotNull();
    }
}