package org.javastart.account.mapper;

import org.javastart.account.dto.AccountResponseDto;
import org.javastart.account.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountResponseDto entityToResponseDto(Account account) {
        return new AccountResponseDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPhone(),
                account.getCreatedAt()
        );
    }
}
