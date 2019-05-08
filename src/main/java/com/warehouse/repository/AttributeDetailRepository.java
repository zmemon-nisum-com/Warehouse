package com.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.model.AttributesDetail;

@Repository
public interface AttributeDetailRepository extends JpaRepository<AttributesDetail, Integer> {


}
