package com.sujit.demo.controller;

import com.sujit.demo.model.Product;
import com.sujit.demo.model.ProductFilter;
import com.sujit.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getFilteredProducts(ProductFilter filter,
                                             @RequestParam(defaultValue = "0") int pageNumber,
                                             @RequestParam(defaultValue = "10") int pageSize,
                                             @RequestParam(defaultValue = "id") Set<String> sortBy,
                                             @RequestParam(required = false, defaultValue = "asc") String sortDirection){


        return productService.filterProducts(filter, pageNumber, pageSize, sortBy,sortDirection);
    }
}

