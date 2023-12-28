package com.mycompany.Propertymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Property_Table")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Property_Title",nullable = false)
    private String title;
    private String description;
    private String ownerName;
    @Column(name = "Email",nullable = false)
    private String ownerEmail;
    private Double price;
    private String address;

}
