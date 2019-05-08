package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.warehouse.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	public List<Inventory> getAllInventoryByProductAttributeId(Integer productAttributeId);
	
	public List<Inventory> getAllInventoryByWarehouseId(Integer warehouseId);

//	@Query(value="SELECT i FROM inventory i JOIN i.product_attribute pr JOIN pr.product p WHERE p.id = ? ",nativeQuery=true)
//	public List<Inventory> getAllInventoryByProductId(Integer productId);
}