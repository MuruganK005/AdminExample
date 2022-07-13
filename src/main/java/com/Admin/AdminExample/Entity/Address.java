package com.Admin.AdminExample.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Address")
@NoArgsConstructor
@AllArgsConstructor
public class Address{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long doorNumber;
    private String street;
    private String landMark;
    private String city;
    private String state;
    private Long pinCode;
//    @OneToOne
//    @JoinColumn(name = "admin_id")
//    private AdminEntity admin;


}