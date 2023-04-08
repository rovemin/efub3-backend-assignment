package efub.assignment.community.account.controller;

import efub.assignment.community.account.domain.Account;
import efub.assignment.community.account.dto.AccountResponseDto;
import efub.assignment.community.account.dto.AccountUpdateRequestDto;
import efub.assignment.community.account.dto.SignUpRequestDto;
import efub.assignment.community.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    /* member 생성 */
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public AccountResponseDto signUp(@RequestBody @Valid final SignUpRequestDto requestDto) {
        Long id = accountService.signUp(requestDto);
        Account findAccount = accountService.findAccountById(id);
        return AccountResponseDto.from(findAccount);
    }

    /* member 1명 조회 */
    @GetMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public AccountResponseDto getAccount(@PathVariable Long accountId) {
        Account findAccount = accountService.findAccountById(accountId);
        return AccountResponseDto.from(findAccount);
    }

    /* member 수정 */
    @PatchMapping("/profile/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public AccountResponseDto update(@PathVariable final Long accountId, @RequestBody @Valid final AccountUpdateRequestDto requestDto) {
        Long id = accountService.update(accountId, requestDto);
        Account findAccount = accountService.findAccountById(id);
        return AccountResponseDto.from(findAccount);
    }

    /* member 삭제 (휴면 계정) */
    @PatchMapping("/{accountId}")
    @ResponseStatus(value = HttpStatus.OK)
    public String withdraw(@PathVariable long accountId) {
        accountService.withdraw(accountId);
        return "삭제가 완료되었습니다.";
    }
}
