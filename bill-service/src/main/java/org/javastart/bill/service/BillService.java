package org.javastart.bill.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.javastart.bill.entity.Bill;
import org.javastart.bill.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BillService {
    private final BillRepository billRepository;

    public Bill getBillById(Long billId) {
        return billRepository
                .findById(billId)
                .orElseThrow(() -> new EntityNotFoundException("Bill not found. ID: " + billId));
    }

    public Long createBill(BigDecimal amount, Boolean isDefault, Long accountId) {
        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setIsDefault(isDefault);
        bill.setAccountId(accountId);

        return billRepository.save(bill).getId();
    }

    public List<Bill> getBillsByAccountId(Long accountId) {
        return billRepository.getBillsByAccountId(accountId);
    }
}
