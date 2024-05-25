package org.javastart.deposit.dto.bill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillRequestDto {
    private BigDecimal amount;
    private Boolean isDefault;
    private Long accountId;
}
