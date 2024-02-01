package com.wsd.sales.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"order\"")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    @ManyToOne
    private CustomerModel customer;
    private double discount;
    private double tax;
    private double total;
    @CreationTimestamp
    private LocalDateTime orderAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
