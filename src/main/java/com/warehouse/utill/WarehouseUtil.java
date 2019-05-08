package com.warehouse.utill;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.warehouse.Dto.WarehouseDto;
import com.warehouse.model.Warehouse;

@Component
public class WarehouseUtil {
	public WarehouseDto convertWarehousetoWarehouseDto(Warehouse warehouse)
	{
		WarehouseDto warehouseDto = new WarehouseDto();
		warehouseDto.setId(warehouse.getId());
		warehouseDto.setAddress(warehouse.getAddress());
		warehouseDto.setWarehouseName(warehouse.getWarehouseName());
		warehouseDto.setCreatedAt(warehouse.getCreatedAt());
		warehouseDto.setUpdatedAt(warehouse.getUpdatedAt());
		warehouseDto.setCountry(warehouse.getCountry());

		return warehouseDto;
	}
	
	public Warehouse convertWarehouseDtotoWarehouse(WarehouseDto warehouseDto)
	{
		Warehouse warehouse = new Warehouse();
		warehouse.setId(warehouseDto.getId());
		warehouse.setAddress(warehouseDto.getAddress());
		warehouse.setWarehouseName(warehouseDto.getWarehouseName());
		warehouse.setCreatedAt(warehouseDto.getCreatedAt());
		warehouse.setUpdatedAt(warehouseDto.getUpdatedAt());
		warehouse.setCountry(warehouseDto.getCountry());

		return warehouse;
	}

	public WarehouseDto convertWarehousetoWarehouseDto(Optional<Warehouse> warehouse) {
		WarehouseDto warehouseDto = new WarehouseDto();
		warehouseDto.setId(warehouse.get().getId());
		warehouseDto.setAddress(warehouse.get().getAddress());
		warehouseDto.setWarehouseName(warehouse.get().getWarehouseName());
		warehouseDto.setCreatedAt(warehouse.get().getCreatedAt());
		warehouseDto.setUpdatedAt(warehouse.get().getUpdatedAt());
		warehouseDto.setCountry(warehouse.get().getCountry());

		return warehouseDto;
	}
}
