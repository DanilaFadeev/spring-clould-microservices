package org.javastart.deposit.client;

import org.javastart.deposit.dto.bill.BillRequestDto;
import org.javastart.deposit.dto.bill.BillResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("bill-service")
public interface BillServiceClient {
    @GetMapping("bills/{billId}")
    BillResponseDto getBillById(@PathVariable("billId") Long billId);

    @PutMapping("bills/{billId}")
    Long updateBillById(@PathVariable("billId") Long billId,
                        @RequestBody BillRequestDto billRequestDto);

    @GetMapping("bills/by-account/{accountId}")
    List<BillResponseDto> getBillsByAccountId(@PathVariable("accountId") Long accountId);
}
