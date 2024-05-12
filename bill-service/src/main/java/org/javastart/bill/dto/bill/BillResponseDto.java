package org.javastart.bill.dto.bill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class BillResponseDto {
    private Long id;
    private BigDecimal amount;
    private Boolean isDefault;
    private Long accountId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
