package org.javastart.deposit.service;

import jakarta.persistence.EntityNotFoundException;
import org.javastart.deposit.client.AccountServiceClient;
import org.javastart.deposit.client.BillServiceClient;
import org.javastart.deposit.dto.DepositRequestDto;
import org.javastart.deposit.dto.account.AccountResponseDto;
import org.javastart.deposit.dto.bill.BillResponseDto;
import org.javastart.deposit.repository.DepositRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepositServiceTest {
    @Mock
    private AccountServiceClient accountServiceClient;

    @Mock
    private BillServiceClient billServiceClient;

    @Mock
    private DepositRepository depositRepository;

    @InjectMocks
    private DepositService depositService;

    private BillResponseDto billResponseDto;
    private AccountResponseDto accountResponseDto;

    @BeforeEach
    public void setup() {
        billResponseDto = new BillResponseDto(
                1L,
                BigDecimal.valueOf(1000),
                true,
                1L,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        accountResponseDto = new AccountResponseDto(
                1L,
                "Account",
                "account@example.com",
                "+1234343",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Test()
    public void depositServiceTest_withBillId() {
        // Arrange
        Mockito
                .when(billServiceClient.getBillById(ArgumentMatchers.anyLong()))
                .thenReturn(billResponseDto);
        Mockito
                .when(accountServiceClient.getAccountById(ArgumentMatchers.anyLong()))
                .thenReturn(accountResponseDto);

        DepositRequestDto depositRequestDto = new DepositRequestDto("email", BigDecimal.valueOf(1000), 1L);

        // Act
        depositService.deposit(depositRequestDto);

        verify(billServiceClient).getBillById(eq(1L));
    }

    @Test()
    public void depositServiceTest_exception() {
        DepositRequestDto depositRequestDto = new DepositRequestDto(null, BigDecimal.valueOf(1000), null);
        assertThrows(NullPointerException.class, () -> depositService.deposit(depositRequestDto));
    }
}
