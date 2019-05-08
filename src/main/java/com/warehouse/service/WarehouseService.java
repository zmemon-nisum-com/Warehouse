package com.warehouse.service;

import java.util.List;

import com.warehouse.Dto.WarehouseDto;
import com.warehouse.model.Warehouse;

public interface WarehouseService {
	public List<WarehouseDto> getAllWarehouse();
	public WarehouseDto getWarehouse(Integer wareHouseId);
	public Warehouse saveWarehouse(WarehouseDto warehouseDto);
	public Warehouse updateWarehouse(WarehouseDto warehouseDto);
	public String deleteWarehouse(Integer warehouseId);
}
