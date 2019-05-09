package com.warehouse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.warehouse.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	public List<Inventory> getAllInventoryByProductAttributeId(Integer productAttributeId);
	
	public List<Inventory> getAllInventoryByWarehouseId(Integer warehouseId);

	@Query(value="SELECT * FROM inventory i, product_attribute pa, product p WHERE i.product_attribute_id = pa.id AND pa.product_id = p.id AND p.id= :pId ",nativeQuery=true)
	public List<Inventory> getAllInventoryByProductId(@Param("pId") Integer productId);

	@Query(value="SELECT * FROM inventory i, product_attribute pa, product p, warehouse w WHERE i.warehouse_id=w.id AND i.product_attribute_id = pa.id AND pa.product_id = p.id AND p.id= :pId AND w.id=:wId",nativeQuery=true)
	public List<Inventory> getAllInventoryByProductIdAndWarehouseId(@Param("pId") Integer productId, @Param("wId") Integer warehouseId);

}