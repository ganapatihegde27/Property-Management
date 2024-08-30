package com.mycompany.property_management.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PROPERTY_TABLE")
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Property_title")
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;

}
