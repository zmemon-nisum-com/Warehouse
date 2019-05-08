package com.warehouse.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.Dto.InventoryDto;
import com.warehouse.Dto.ProductDto;
import com.warehouse.exception.WarehouseException;
import com.warehouse.model.Inventory;
import com.warehouse.service.InventoryService;

@RestController
@RequestMapping("/inventory/")
public class IntentoryController {

	@Autowired
	private InventoryService inventoryService;
	
	
	@GetMapping("/")
	public List<InventoryDto> getAllInventory() throws WarehouseException {
		List<InventoryDto> inventoryList = inventoryService.getAllInventory();
		
		return inventoryList;
	}
	
	@GetMapping("/{inventoryId}")
	public InventoryDto getInventory(@PathVariable Integer inventoryId) throws WarehouseException {
		InventoryDto inventoryDto = inventoryService.getInventory(inventoryId);

		return inventoryDto;
	}
	
	@GetMapping("/productAttribute/{productAttributeId}")
	public List<InventoryDto> getInventoryByProductAttribute(@PathVariable Integer productAttributeId) throws WarehouseException {
		List<InventoryDto> inventoryDtoList = inventoryService.getAllInventoryByProductAttribute(productAttributeId);
		
		return inventoryDtoList;
	}
	
	@GetMapping("/warehouse/{warehouseId}")
	public List<InventoryDto> getInventoryByWarehouse(@PathVariable Integer warehouseId) throws WarehouseException {
		List<InventoryDto> inventoryDtoList = inventoryService.getAllInventoryByWarehouse(warehouseId);
		
		return inventoryDtoList;
	}
	
	@GetMapping("/product/{productId}")
	public ProductDto getAllInventoryByProduct(@PathVariable Integer productId) throws WarehouseException {
		ProductDto productDto = inventoryService.getAllInventoryByProduct(productId);
		
		return productDto;
	}
	
	@DeleteMapping("/{inventoryId}")
	public String deleteInventory(@PathVariable Integer inventoryId) throws WarehouseException {
		inventoryService.deleteInventory(inventoryId);
		
		return "Inventory Deleted";
	}
	
	@PostMapping("/{warehouseId}")
	public Inventory saveInventory(@RequestBody InventoryDto inventoryDto, @PathVariable Integer warehouseId) throws WarehouseException {
		Inventory savedInventory = inventoryService.saveInventory(inventoryDto, warehouseId);
		
		return savedInventory;
	}
	
	@PostMapping("/")
	public List<Inventory> saveInventoryToWarehouses(@RequestBody InventoryDto inventoryDto) throws WarehouseException {
		List<Inventory> inventoryList = inventoryService.saveInventoryList(inventoryDto);
		
		return inventoryList;
	}
	
	@PutMapping("/")
	public Inventory uodateInventory(@RequestBody InventoryDto inventoryDto) throws WarehouseException {
		Inventory updatedInventory = inventoryService.updateInventory(inventoryDto);
		
		return updatedInventory;
	}
}