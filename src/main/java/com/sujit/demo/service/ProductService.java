package com.sujit.demo.service;

import com.sujit.demo.model.Product;
import com.sujit.demo.model.ProductFilter;
import com.sujit.demo.repository.ProductRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public Page<Product> filterProducts(ProductFilter filter, int pageNumber, int pageSize, Set<String> sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        for (String sortProperty : sortBy) {
            orders.add(Sort.Order.asc(sortProperty));
        }
        Sort sort = Sort.by(orders);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Specification<Product> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getBrand() != null) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), filter.getBrand()));
            }

            if (filter.getMinPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), filter.getMinPrice()));
            }

            if (filter.getMaxPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), filter.getMaxPrice()));
            }

            if (filter.getStorageSize() != null) {
                predicates.add(criteriaBuilder.equal(root.get("storageSize"), filter.getStorageSize()));
            }

            if (filter.getDisplay() != null) {
                predicates.add(criteriaBuilder.equal(root.get("display"), filter.getDisplay()));
            }

            if (filter.getType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("type"), filter.getType()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return productRepository.findAll(specification, pageable);
    }


}

