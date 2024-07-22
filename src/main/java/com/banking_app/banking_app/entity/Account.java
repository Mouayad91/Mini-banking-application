package com.banking_app.banking_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity //JPA
@Table(name="accounts")
public class Account {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="accoount_owner_name")
    private String accountOwnerName;

    @Column(name="balance")
    private double balance;

}
