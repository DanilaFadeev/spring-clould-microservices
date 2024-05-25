package org.javastart.account.mapper;

import org.javastart.account.dto.AccountResponseDto;
import org.javastart.account.entity.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface AccountMapper {
    AccountResponseDto toAccountResponseDto(Account account);
}
