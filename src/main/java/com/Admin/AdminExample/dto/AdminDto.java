package com.Admin.AdminExample.dto;
import com.Admin.AdminExample.Entity.Address;
import com.Admin.AdminExample.Entity.AdminEntity;
import com.Admin.AdminExample.Enum.TypesOfRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto extends AdminEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long phoneNumber;
    private String email;
    private Address address;
    private TypesOfRole rolesCreator;

//    public AdminDto(Long l, String murugan, Long l1, String s, Address addresss, TypesOfRole superAdmin) {
//        id = l;
//        name = murugan;
//        phoneNumber = l1;
//        email=s;
//        address=addresss;
//        rolesCreator=superAdmin;
//    }
}
