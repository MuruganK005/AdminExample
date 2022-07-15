package com.Admin.AdminExample.Entity;

import com.Admin.AdminExample.Enum.TypesOfRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "AdminTable")
@NoArgsConstructor
@AllArgsConstructor
//@SQLDelete(sql = "Update admin_table SET account_state = true WHERE id=?")
//@Where(clause = "account_state=false")
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

