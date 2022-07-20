package com.Admin.AdminExample.dto;
import com.Admin.AdminExample.Entity.Address;
import com.Admin.AdminExample.Enum.TypesOfRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private Long id=null;
    private String name;
    private Long phoneNumber;
    private String email;
    private Address address;
    private TypesOfRole rolesCreator;
    private Boolean deleted = false;
    private Boolean status = false;

}