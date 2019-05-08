package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warehouse.model.ProductAttribute;

public interface ProductAttributeReposiroty extends JpaRepository<ProductAttribute, Integer> {

}
