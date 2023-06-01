package com.sujit.demo.model;

import lombok.Data;

@Data
public class ProductFilter {
    private String brand;

    private Integer minPrice;

    private Integer maxPrice;

    private Integer storageSize;

    private String display;

    private String type;

}

