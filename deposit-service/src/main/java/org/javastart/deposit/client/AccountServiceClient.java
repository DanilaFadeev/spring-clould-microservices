package org.javastart.deposit.client;

import org.javastart.deposit.dto.account.AccountResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("account-service")
public interface AccountServiceClient {
    @GetMapping("/accounts/{accountId}")
    AccountResponseDto getAccountById(@PathVariable("accountId") Long accountId);
}
