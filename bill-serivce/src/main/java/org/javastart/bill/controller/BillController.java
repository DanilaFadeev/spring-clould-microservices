package org.javastart.bill.controller;

import lombok.RequiredArgsConstructor;
import org.javastart.bill.dto.bill.BillRequestDto;
import org.javastart.bill.dto.bill.BillResponseDto;
import org.javastart.bill.entity.Bill;
import org.javastart.bill.mapper.BillMapper;
import org.javastart.bill.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;
    private final BillMapper billMapper;

    @GetMapping("/{billId}")
    @ResponseStatus(HttpStatus.OK)
    public BillResponseDto getBillById(@PathVariable("billId") Long billId) {
        Bill bill = billService.getBillById(billId);
        return billMapper.entityToResponseDto(bill);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createBill(@RequestBody BillRequestDto billRequestDto) {
        return billService.createBill(
                billRequestDto.getAmount(),
                billRequestDto.getIsDefault(),
                billRequestDto.getAccountId()
        );
    }
}
