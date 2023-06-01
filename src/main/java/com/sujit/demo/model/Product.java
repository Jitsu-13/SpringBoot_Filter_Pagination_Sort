package com.sujit.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private Integer price;

    private int storageSize;

    private String display;

    private String type;

    private LocalDate date;

}
