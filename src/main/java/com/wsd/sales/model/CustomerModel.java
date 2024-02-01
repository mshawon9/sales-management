package com.wsd.sales.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String zip;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String email;
}
