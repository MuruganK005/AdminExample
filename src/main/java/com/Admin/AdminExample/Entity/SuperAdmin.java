package com.Admin.AdminExample.Entity;

import com.Admin.AdminExample.Enum.TypesOfRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "SuperAdminName")
    private String superAdminName;
    @Column(name = "SuperAdminPhoneNumber")
    private String superAdminPhNumber;
    @Enumerated(EnumType.STRING)
    private TypesOfRole role;
}
