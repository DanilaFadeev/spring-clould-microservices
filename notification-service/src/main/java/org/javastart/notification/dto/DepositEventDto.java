package org.javastart.notification.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class DepositEventDto {
    public String email;
    public BigDecimal amount;
}
