package org.javastart.bill.mapper;

import org.javastart.bill.dto.bill.BillResponseDto;
import org.javastart.bill.entity.Bill;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface BillMapper {
    BillResponseDto toResponseDto(Bill bill);
}
