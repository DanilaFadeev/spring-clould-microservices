package org.javastart.deposit.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.javastart.deposit.client.AccountServiceClient;
import org.javastart.deposit.client.BillServiceClient;
import org.javastart.deposit.dto.DepositRequestDto;
import org.javastart.deposit.dto.DepositResponseDto;
import org.javastart.deposit.dto.account.AccountResponseDto;
import org.javastart.deposit.dto.bill.BillRequestDto;
import org.javastart.deposit.dto.bill.BillResponseDto;
import org.javastart.deposit.entity.Deposit;
import org.javastart.deposit.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final AccountServiceClient accountServiceClient;
    private final BillServiceClient billServiceClient;
    private final DepositRepository depositRepository;

    public DepositResponseDto deposit(DepositRequestDto depositRequestDto) {
        Long billId = depositRequestDto.getBillId();
        BillResponseDto billResponseDto = billServiceClient.getBillById(billId);

        BigDecimal depositAmount = billResponseDto.getAmount().add(depositRequestDto.getAmount());

        BillRequestDto billRequestDto = new BillRequestDto();
        billRequestDto.setAmount(depositAmount);
        billRequestDto.setIsDefault(billResponseDto.getIsDefault());
        billRequestDto.setAccountId(billResponseDto.getAccountId());

        billServiceClient.updateBillById(billId, billRequestDto);

        AccountResponseDto accountResponseDto = accountServiceClient.getAccountById(billResponseDto.getAccountId());
        depositRepository.save(new Deposit(depositAmount, accountResponseDto.getEmail(), billId));

        return new DepositResponseDto(depositAmount, accountResponseDto.getEmail());
    }
}
