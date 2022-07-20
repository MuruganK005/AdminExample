package com.Admin.AdminExample.dto;
import com.Admin.AdminExample.Entity.Address;
import com.Admin.AdminExample.Entity.SuperAdmin;
import com.Admin.AdminExample.Enum.TypesOfRole;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SuperAdminDto {
    private Long id;
    private String superAdminName;
    private String superAdminPhNumber;
    private TypesOfRole role;
    private Address address;
}
