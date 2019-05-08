package com.warehouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.Dto.WarehouseDto;
import com.warehouse.model.Warehouse;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.utill.WarehouseUtil;

@Service
public class WarehouseServiceImpl implements WarehouseService {
	
	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private WarehouseUtil warehouseUtil;
	
	@Override
	public List<WarehouseDto> getAllWarehouse() {
		List<Warehouse> warehouseList = warehouseRepository.findAll();
		List<WarehouseDto> warehouseDtoList = new ArrayList<WarehouseDto>();
		for(Warehouse warehouse:warehouseList) {
			warehouseDtoList.add(warehouseUtil.convertWarehousetoWarehouseDto(warehouse));
		}
		
		return warehouseDtoList;
	}

	@Override
	public WarehouseDto getWarehouse(Integer wareHouseId) {
		Optional<Warehouse> warehouse = warehouseRepository.findById(wareHouseId);
		WarehouseDto warehouseDto = warehouseUtil.convertWarehousetoWarehouseDto(warehouse);
		
		return warehouseDto;
	}

	@Override
	public Warehouse saveWarehouse(WarehouseDto warehouseDto) {
		Warehouse warehouse = warehouseUtil.convertWarehouseDtotoWarehouse(warehouseDto);
		
		Warehouse status = warehouseRepository.save(warehouse);
		return status;
	}

	@Override
	public Warehouse updateWarehouse(WarehouseDto warehouseDto) {
		Warehouse warehouse = warehouseUtil.convertWarehouseDtotoWarehouse(warehouseDto);
		Warehouse status = warehouseRepository.save(warehouse);
		return status;
	}

	@Override
	public String deleteWarehouse(Integer warehouseId) {
		warehouseRepository.deleteById(warehouseId);
		return "Deleted";
	}

}
