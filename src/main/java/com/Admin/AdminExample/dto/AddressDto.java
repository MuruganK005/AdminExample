package com.Admin.AdminExample.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddressDto {
    private Long id;
    private Long doorNumber;
    private String street;
    private String landMark;
    private String city;
    private String state;
    private String country;
    private Long pinCode;
}
