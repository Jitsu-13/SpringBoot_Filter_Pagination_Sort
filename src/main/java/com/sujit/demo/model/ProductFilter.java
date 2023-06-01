package com.sujit.demo.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ProductFilter {
    private String brand;

    private Integer minPrice;

    private Integer maxPrice;

    private Integer storageSize;

    private String display;

    private String type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

}

