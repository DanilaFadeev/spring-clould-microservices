package org.javastart.deposit.service;

import lombok.RequiredArgsConstructor;
import org.javastart.deposit.client.AccountServiceClient;
import org.javastart.deposit.client.BillServiceClient;
import org.javastart.deposit.dto.DepositRequestDto;
import org.javastart.deposit.dto.bill.BillResponseDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final AccountServiceClient accountServiceClient;
    private final BillServiceClient billServiceClient;

    public void deposit(DepositRequestDto depositRequestDto) {
        Long billId = depositRequestDto.getBillId();
        BillResponseDto bill = billServiceClient.getBillById(billId);
        System.out.println(bill);
    }
}
