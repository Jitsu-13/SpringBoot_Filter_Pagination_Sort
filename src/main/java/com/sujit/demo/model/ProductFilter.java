package com.sujit.demo.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ProductFilter {
    private String brand;

    private Integer minPrice;

    private Integer maxPrice;

    private Integer storageSize;

    private String display;

    private String type;

    private LocalDate startDate;

    private LocalDate endDate;

}

