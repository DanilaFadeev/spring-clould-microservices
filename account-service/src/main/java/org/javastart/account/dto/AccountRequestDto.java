package org.javastart.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AccountRequestDto {
    private String name;
    private String email;
    private String phone;
}
