package com.warehouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.Dto.InventoryDto;
import com.warehouse.model.Inventory;
import com.warehouse.model.Warehouse;
import com.warehouse.repository.InventoryRepository;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.utill.InventoryUtil;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired 
	private InventoryUtil inventoryUtil;
	
	@Override
	public List<InventoryDto> getAllInventory() {
		List<Inventory> inventoryList = inventoryRepository.findAll();
		List<InventoryDto> inventoryDtoList = new ArrayList<InventoryDto>();
		for(Inventory inventory:inventoryList)
		{
			inventoryDtoList.add(inventoryUtil.ConvertInventoryToInventoryDto(inventory));
		}
		
		return inventoryDtoList;
	}

	@Override
	public InventoryDto getInventory(Integer inventoryId) {
		Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
		InventoryDto inventoryDto = inventoryUtil.ConvertInventoryToInventoryDtoo(inventory);

		return inventoryDto;
	}

	@Override
	public List<InventoryDto> getAllInventoryByProductAttribute(Integer productAttributeId) {
		List<Inventory> inventoryList = inventoryRepository.getAllInventoryByProductAttributeId(productAttributeId);
		List<InventoryDto> inventoryDtoList = new ArrayList<InventoryDto>();
		for(Inventory inventory:inventoryList)
		{
			inventoryDtoList.add(inventoryUtil.ConvertInventoryToInventoryDto(inventory));
		}
		
		return inventoryDtoList;
	}

	@Override
	public List<InventoryDto> getAllInventoryByWarehouse(Integer warehouseId) {
		List<Inventory> inventoryList = inventoryRepository.getAllInventoryByWarehouseId(warehouseId);
		List<InventoryDto> inventoryDtoList = new ArrayList<InventoryDto>();
		for(Inventory inventory:inventoryList)
		{
			inventoryDtoList.add(inventoryUtil.ConvertInventoryToInventoryDto(inventory));
		}
		
		return inventoryDtoList;
	}

	@Override
	public Inventory saveInventory(InventoryDto inventoryDto, Integer warehouseId) {
		inventoryDto.setWarehouseId(warehouseId);
		Inventory inventory = inventoryUtil.ConvertInventoryDtoToInventory(inventoryDto);
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory updateInventory(InventoryDto inventoryDto) {
		Inventory inventory = inventoryUtil.ConvertInventoryDtoToInventory(inventoryDto);
		return inventoryRepository.save(inventory);
	}

	@Override
	public String deleteInventory(Integer inventoryId) {
		inventoryRepository.deleteById(inventoryId);	
		return "Inventory Deleted";
	}

	@Override
	public List<Inventory> getAllInventoryByWarehouseProduct(Integer warehouseId, Integer productId) {
		List<Inventory> inventoryList = inventoryRepository.getAllInventoryByProductIdAndWarehouseId(productId, warehouseId);
		
		return inventoryList;
	}

	@Override
	public List<Inventory> getAllInventoryByProduct(Integer productId) {
		List<Inventory> inventoryList = inventoryRepository.getAllInventoryByProductId(productId);
		
		return inventoryList;
	}
	
	@Override
	public List<Inventory> saveInventoryList(InventoryDto inventoryDto) {
		Inventory inventory = inventoryUtil.ConvertInventoryDtoToInventory(inventoryDto);
		List<Warehouse> warehousesList = warehouseRepository.findAll();
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		for(Warehouse warehouse:warehousesList)
		{
			inventory.setWarehouse(warehouse);
			inventoryList.add(inventoryRepository.save(inventory));
		}
		
		return inventoryList;
	}
}
