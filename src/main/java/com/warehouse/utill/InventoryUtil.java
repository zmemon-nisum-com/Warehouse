package com.warehouse.utill;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.warehouse.Dto.InventoryDto;
import com.warehouse.model.Inventory;
import com.warehouse.model.ProductAttribute;
import com.warehouse.model.Warehouse;

@Component
public class InventoryUtil {
	
	public Inventory convertInventoryDtoToInventory(InventoryDto inventoryDto)
	{
		Inventory inventory = new Inventory();
		inventory.setId(inventoryDto.getId());
		inventory.setAvailableQuantity(inventoryDto.getAvailableQuantity());
		inventory.setInStock(inventoryDto.getInStock());
		inventory.setInTransit(inventoryDto.getInTransit());		
		inventory.setCreatedAt(inventoryDto.getCreatedAt());
		inventory.setUpdatedAt(inventoryDto.getUpdatedAt());
		
		ProductAttribute productAttribute = new ProductAttribute();
		productAttribute.setId(inventoryDto.getProductAttributeId());
		inventory.setProductAttribute(productAttribute);

		if(inventoryDto.getWarehouseId() == null)
		{
			
		}
		else if(inventoryDto.getWarehouseId() != null || inventoryDto.getWarehouseId() != 0)
		{
			Warehouse warehouse = new Warehouse();
			warehouse.setId(inventoryDto.getWarehouseId());
			inventory.setWarehouse(warehouse);
		}

		return inventory;
	}
	
	
	public InventoryDto convertInventoryToInventoryDto(Inventory inventory)
	{
		InventoryDto InventoryDto = new InventoryDto();
		InventoryDto.setId(inventory.getId());
		InventoryDto.setAvailableQuantity(inventory.getAvailableQuantity());
		InventoryDto.setInStock(inventory.getInStock());
		InventoryDto.setInTransit(inventory.getInTransit());		
		InventoryDto.setCreatedAt(inventory.getCreatedAt());
		InventoryDto.setUpdatedAt(inventory.getUpdatedAt());
		
		InventoryDto.setProductAttributeId(inventory.getProductAttribute().getId());
		
		InventoryDto.setWarehouseId(inventory.getWarehouse().getId());

		return InventoryDto;
	}
	
	public InventoryDto convertInventoryToInventoryDtoo(Optional<Inventory> inventory)
	{
		InventoryDto InventoryDto = new InventoryDto();
		InventoryDto.setId(inventory.get().getId());
		InventoryDto.setAvailableQuantity(inventory.get().getAvailableQuantity());
		InventoryDto.setInStock(inventory.get().getInStock());
		InventoryDto.setInTransit(inventory.get().getInTransit());		
		InventoryDto.setCreatedAt(inventory.get().getCreatedAt());
		InventoryDto.setUpdatedAt(inventory.get().getUpdatedAt());
		
		InventoryDto.setProductAttributeId(inventory.get().getProductAttribute().getId());
		
		InventoryDto.setWarehouseId(inventory.get().getWarehouse().getId());

		return InventoryDto;
	}

	public List<Inventory> convertInvertoryToInventoryList(Inventory inventory, List<Warehouse> warehousesList)
	{
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		for(Warehouse warehouse : warehousesList)
		{
			System.out.println(warehouse.getWarehouseName());
			inventory.setWarehouse(warehouse);
			inventoryList.add(inventory);
		}
		
		return inventoryList;
	}
	
}
