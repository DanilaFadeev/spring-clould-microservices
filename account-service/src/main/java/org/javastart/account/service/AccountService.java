package org.javastart.account.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.javastart.account.entity.Account;
import org.javastart.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Account getAccountById(Long accountId) {
        return accountRepository
                .findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found. ID: " + accountId));
    }

    public Long createAccount(String name, String email, String phone) {
        Account account = new Account();
        account.setName(name);
        account.setEmail(email);
        account.setPhone(phone);

        return accountRepository.save(account).getId();
    }

    public Account updateAccount(Long id, String name, String email, String phone) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setEmail(email);
        account.setPhone(phone);
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long id) {
        Account account = getAccountById(id);
        accountRepository.deleteById(id);
        return account;
    }
}
