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

@Getter // Lombok annotation to generate getter methods
@Setter // Lombok annotation to generate setter methods
@NoArgsConstructor // Lombok annotation to generate no-args constructor
@AllArgsConstructor // Lombok annotation to generate all-args constructor

@Entity // JPA annotation to mark this class as an entity
@Table(name="accounts") // Specifies the table name in the database
public class Account {
    
    @Id // Marks this field as the primary key
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Specifies the primary key generation strategy
    private Long id;

    @Column(name="accoount_owner_name") // Maps this field to the specified column name in the table
    private String accountOwnerName;

    @Column(name="balance")
    private double balance;

}
