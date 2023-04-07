package efub.assignment.community.account.domain;

import efub.assignment.community.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static efub.assignment.community.account.domain.AccountStatus.REGISTERED;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private String encodedPassword;

    @Column(nullable = false, updatable = false, length = 16)
    private String nickname;

    @Column(nullable = false, length = 30)
    private String university;

    @Column(nullable = false, length = 16)
    private Long studentId;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Builder

    public Account(Long accountId, String email, String password, String nickname, String university, Long studentId) {
        this.accountId = accountId;
        this.email = email;
        this.encodedPassword = password;
        this.nickname = nickname;
        this.university = university;
        this.studentId = studentId;
        this.status = REGISTERED;
    }
}
