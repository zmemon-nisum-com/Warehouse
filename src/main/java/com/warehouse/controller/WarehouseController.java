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

import com.warehouse.Dto.WarehouseDto;
import com.warehouse.exception.WarehouseException;
import com.warehouse.model.Warehouse;
import com.warehouse.service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	@GetMapping("/")
	public List<WarehouseDto> getAllWarehouse() throws WarehouseException {
		List<WarehouseDto> warehouseDtoList = warehouseService.getAllWarehouse();
		
		return warehouseDtoList;
	}
	
	@GetMapping("/{wareHouseId}")
	public WarehouseDto getWarehouse(@PathVariable Integer wareHouseId) throws WarehouseException {
		WarehouseDto warehouseDto = warehouseService.getWarehouse(wareHouseId);
		
		return warehouseDto;
	}
	
	@DeleteMapping("/{wareHouseId}")
	public String deleteWarehouse(@PathVariable Integer wareHouseId) throws WarehouseException {
		warehouseService.deleteWarehouse(wareHouseId);
		
		return "Deleted";
	}
	
	@PostMapping("/")
	public Warehouse saveWarehouse(@RequestBody WarehouseDto warehouseDto) throws WarehouseException {
		Warehouse savedWarehouse = warehouseService.saveWarehouse(warehouseDto);

		return savedWarehouse;
	}
	
	@PutMapping("/")
	public Warehouse updateWarehouse(@RequestBody WarehouseDto warehouseDto) throws WarehouseException {
		Warehouse updatedWarehouse = warehouseService.updateWarehouse(warehouseDto);
		
		return updatedWarehouse;
	}
}
