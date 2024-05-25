package org.javastart.account.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.javastart.account.dto.AccountRequestDto;
import org.javastart.account.dto.AccountResponseDto;
import org.javastart.account.entity.Account;
import org.javastart.account.mapper.AccountMapper;
import org.javastart.account.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping("/")
    @Operation(operationId = "getAccounts", description = "Returns the list of all the accounts", tags = "account")
    public List<AccountResponseDto> getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        return accounts.stream().map(accountMapper::toAccountResponseDto).toList();
    }

    @GetMapping("/{accountId}")
    @Operation(operationId = "getAccount", description = "Returns an account by ID", tags = "account")
    public AccountResponseDto getAccount(@PathVariable Long accountId) {
        Account account = accountService.getAccountById(accountId);
        return accountMapper.toAccountResponseDto(account);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(operationId = "createAccount", description = "Creates a new account", tags = "account")
    public Long createAccount(@RequestBody AccountRequestDto accountRequestDto) {
        return accountService.createAccount(
                accountRequestDto.getName(),
                accountRequestDto.getEmail(),
                accountRequestDto.getPhone()
        );
    }

    @PutMapping("/{accountId}")
    @Operation(operationId = "updateAccount", description = "Updates an account by ID", tags = "account")
    public AccountResponseDto updateAccount(@RequestBody AccountRequestDto accountRequestDto,
                                            @PathVariable("accountId") long accountId) {
        Account account = accountService.updateAccount(
                accountId,
                accountRequestDto.getName(),
                accountRequestDto.getEmail(),
                accountRequestDto.getPhone()
        );
        return accountMapper.toAccountResponseDto(account);
    }

    @DeleteMapping("/{accountId}")
    @Operation(operationId = "deleteAccount", description = "Deletes an account by ID", tags = "account")
    public AccountResponseDto deleteAccount(@PathVariable("accountId") long accountId) {
        Account account = accountService.deleteAccount(accountId);
        return accountMapper.toAccountResponseDto(account);
    }
}
