package org.javastart.bill.mapper;

import org.javastart.bill.dto.bill.BillResponseDto;
import org.javastart.bill.entity.Bill;
import org.springframework.stereotype.Component;

@Component
public class BillMapper {
    public BillResponseDto entityToResponseDto(Bill bill) {
        return new BillResponseDto(
                bill.getId(),
                bill.getAmount(),
                bill.getIsDefault(),
                bill.getAccountId(),
                bill.getCreatedAt(),
                bill.getUpdatedAt()
        );
    }
}
