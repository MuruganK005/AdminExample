package com.Admin.AdminExample.Entity;

import com.Admin.AdminExample.Enum.TypesOfRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "Update admin_entity SET account_state = true WHERE id=?")//This Line  SoftDelete the data as true so in DB its shown as 1
//@Where(clause = "account_state=false")//this Line used to not shown in postman console
@FilterDef(name = "deletedAdminFilter",parameters = @ParamDef(name = "isDeleted",type = "boolean"))
@Filter(name = "deletedAdminFilter",condition = "account_state= :isDeleted")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "AdminName")
    private String name;
    @Column(name = "PhoneNumber")
    private Long phoneNumber;
    @Column(name = "AdminEmail")
    private String email;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
    @Enumerated(EnumType.STRING)
    private TypesOfRole rolesCreator;
    @Column(name = "AccountState")
    private Boolean deleted=false;
}

