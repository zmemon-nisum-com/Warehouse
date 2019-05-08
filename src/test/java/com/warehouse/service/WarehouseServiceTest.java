package com.warehouse.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import com.warehouse.Dto.WarehouseDto;
import com.warehouse.config.WebMvcConfig;
import com.warehouse.model.Country;
import com.warehouse.model.Warehouse;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.service.WarehouseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcConfig.class})
@WebAppConfiguration
public class WarehouseServiceTest {

	@Autowired
	private WarehouseService warehouseService;
	
	@Mock
	private WarehouseRepository warehouseRepository;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(warehouseService,"warehouseRepository", warehouseRepository);
	}
	
	@Test
	public void getAllWarehouse() throws Exception {
		List<Warehouse> warehouseList = getWarehouseList();
		
		when(warehouseRepository.findAll()).thenReturn(warehouseList);
		Assert.assertNotNull(warehouseService.getAllWarehouse());
	}
	
	@Test
	public void getWarehouseById() throws Exception {
		Warehouse warehouse = getWarehouse();
		when(warehouseRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(warehouse));
		Assert.assertNotNull(warehouseService.getWarehouse(1));
	}
	
	@Test
	public void daleteWarehouse() throws Exception {
		String status = "Deleted";
		
		Mockito.doNothing().when(warehouseRepository).deleteById(Mockito.anyInt());
		Assert.assertEquals(warehouseService.deleteWarehouse(1),status);
	}
	
	@Test
	public void saveWarehouse() throws Exception {
		Warehouse warehouse = getWarehouse();
		WarehouseDto warehouseDto = getWarehouseDto();
		warehouseDto.setId(1);
		
		when(warehouseRepository.save(Mockito.any())).thenReturn(warehouse);;
		Assert.assertNotNull(warehouseService.saveWarehouse(warehouseDto));
	}
	
	@Test
	public void updateWarehouse() throws Exception {
		Warehouse warehouse = getWarehouse();
		WarehouseDto warehouseDto = getWarehouseDto();
		
		when(warehouseRepository.save(Mockito.any())).thenReturn(warehouse);;
		Assert.assertNotNull(warehouseService.updateWarehouse(warehouseDto));
	}
	
	public Warehouse getWarehouse()
	{
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1);
		Country country = new Country();
		country.setId(1);
		warehouse.setCountry(country);
		warehouse.setWarehouseName("Mega");
		
		return warehouse;
	}
	
	public List<Warehouse> getWarehouseList()
	{
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1);
		Country country = new Country();
		country.setId(1);
		warehouse.setCountry(country);
		warehouse.setWarehouseName("Mega");
		
		List<Warehouse> warehouseList = new ArrayList<Warehouse>();
		warehouseList.add(warehouse);
		
		return warehouseList;
	}
	
	public WarehouseDto getWarehouseDto()
	{
		WarehouseDto warehouseDto = new WarehouseDto();
		Country country = new Country();
		country.setId(1);
		warehouseDto.setCountry(country);
		warehouseDto.setWarehouseName("Mega");
		
		return warehouseDto;
	}
}