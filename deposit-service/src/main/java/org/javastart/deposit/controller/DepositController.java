package org.javastart.deposit.controller;

import lombok.RequiredArgsConstructor;
import org.javastart.deposit.dto.DepositRequestDto;
import org.javastart.deposit.service.DepositService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepositController {
    private final DepositService depositService;

    @PostMapping("/")
    public Long createDeposit(@RequestBody DepositRequestDto depositRequestDto) {
        depositService.deposit(depositRequestDto);
        return 0L;
    }
}
