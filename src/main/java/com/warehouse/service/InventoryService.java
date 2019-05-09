package com.warehouse.service;

import java.util.List;

import com.warehouse.Dto.InventoryDto;
import com.warehouse.model.Inventory;

public interface InventoryService {
	public List<InventoryDto> getAllInventory();
	public InventoryDto getInventory(Integer inventoryId);
	public List<InventoryDto> getAllInventoryByProductAttribute(Integer productAttributeId);
	public List<InventoryDto> getAllInventoryByWarehouse(Integer warehouseId);
	public Inventory saveInventory(InventoryDto inventory, Integer warehouseId);
	public Inventory updateInventory(InventoryDto inventory);
	public String deleteInventory(Integer inventoryId);
	public List<InventoryDto> getAllInventoryByWarehouseProduct(Integer warehouseId, Integer productId);
	public List<Inventory> saveInventoryList(InventoryDto inventory);
	public List<InventoryDto> getAllInventoryByProduct(Integer productId);
}
