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

import com.warehouse.Dto.InventoryDto;
import com.warehouse.config.WebMvcConfig;
import com.warehouse.model.Inventory;
import com.warehouse.model.ProductAttribute;
import com.warehouse.model.Warehouse;
import com.warehouse.repository.InventoryRepository;
import com.warehouse.repository.WarehouseRepository;
import com.warehouse.utill.InventoryUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcConfig.class})
@WebAppConfiguration
public class InventoryServiceTest {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Mock
	private InventoryRepository inventoryRepository;
	
	@Mock
	private WarehouseRepository warehouseRepository;
	
	@Mock 
	private ProductService productService;
	
	@Mock 
	private InventoryUtil inventoryUtil;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);

        ReflectionTestUtils.setField(inventoryService,"inventoryRepository", inventoryRepository);
		ReflectionTestUtils.setField(inventoryService,"inventoryUtil", inventoryUtil);
        ReflectionTestUtils.setField(inventoryService,"warehouseRepository", warehouseRepository);
        ReflectionTestUtils.setField(inventoryService,"productService", productService);
	}
	
	@Test
	public void getAllInventory() throws Exception {
		List<Inventory> inventoryList = getInventoryList();
		
		when(inventoryRepository.findAll()).thenReturn(inventoryList);
		Assert.assertNotNull(inventoryService.getAllInventory());
	}

	@Test
	public void getInventoryById() throws Exception {
		Inventory inventory = getInventory();
		InventoryDto inventoryDto = getInventoryDto();
		
		when(inventoryRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(inventory));
		when(inventoryUtil.convertInventoryToInventoryDtoo(Mockito.any())).thenReturn(inventoryDto);
		Assert.assertNotNull(inventoryService.getInventory(1));
	}
	
	@Test
	public void deleteInventory() throws Exception {
		String status = "Inventory Deleted";
		
		Mockito.doNothing().when(inventoryRepository).deleteById(Mockito.anyInt());
		Assert.assertEquals(inventoryService.deleteInventory(1),status);
	}
	
	@Test
	public void getInventoryByProductAtrribute() throws Exception {
		List<Inventory> inventoryList = getInventoryList();
		
		when(inventoryRepository.getAllInventoryByProductAttributeId(Mockito.anyInt())).thenReturn(inventoryList);
		
		Assert.assertNotNull(inventoryService.getAllInventoryByProductAttribute(1));
	}
	
	@Test
	public void getInventoryByWarehouse() throws Exception {
		List<Inventory> inventoryList = getInventoryList();
		
		when(inventoryRepository.getAllInventoryByWarehouseId(Mockito.anyInt())).thenReturn(inventoryList);
		
		Assert.assertNotNull(inventoryService.getAllInventoryByWarehouse(1));
	}
	
	@Test
	public void saveInventory() throws Exception {
		Inventory inventory = getInventory();
		InventoryDto inventoryDto = getInventoryDto();		
		inventoryDto.setId(1);
		
		when(inventoryRepository.save(Mockito.any())).thenReturn(inventory);
		
		Assert.assertNotNull(inventoryService.saveInventory(inventoryDto, inventoryDto.getWarehouseId()));
	}
	
	@Test
	public void updateInventory() throws Exception {
		Inventory inventory = getInventory();
		InventoryDto inventoryDto = getInventoryDto();		
		inventoryDto.setId(1);
		
		when(inventoryRepository.save(Mockito.any())).thenReturn(inventory);
		
		Assert.assertNotNull(inventoryService.updateInventory(inventoryDto));
	}
	
	public Inventory getInventory()
	{
		Inventory inventory = new Inventory();
		inventory.setId(1);
		inventory.setAvailableQuantity(10);
		inventory.setInStock(15);
		inventory.setInTransit(20);
		ProductAttribute productAttribute = new ProductAttribute();
		productAttribute.setId(1);
		inventory.setProductAttribute(productAttribute);
		
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1);
		inventory.setWarehouse(warehouse);
		
		return inventory;
	}
	
	public List<Inventory> getInventoryList()
	{
		Inventory inventory = new Inventory();
		inventory.setId(1);
		inventory.setAvailableQuantity(10);
		inventory.setInStock(15);
		inventory.setInTransit(20);
		ProductAttribute productAttribute = new ProductAttribute();
		productAttribute.setId(1);
		inventory.setProductAttribute(productAttribute);
		
		Warehouse warehouse = new Warehouse();
		warehouse.setId(1);
		inventory.setWarehouse(warehouse);
		
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		inventoryList.add(inventory);
		
		return inventoryList;
	}
	
	public InventoryDto getInventoryDto()
	{
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setId(1);
		inventoryDto.setAvailableQuantity(10);
		inventoryDto.setInStock(15);
		inventoryDto.setInTransit(20);
		inventoryDto.setProductAttributeId(1);
		inventoryDto.setWarehouseId(1);
		
		return inventoryDto;
	}
}
