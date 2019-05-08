package com.warehouse.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse.Dto.InventoryDto;
import com.warehouse.config.WebMvcConfig;
import com.warehouse.controller.IntentoryController;
import com.warehouse.model.Inventory;
import com.warehouse.model.ProductAttribute;
import com.warehouse.model.Warehouse;
import com.warehouse.service.InventoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcConfig.class})
@WebAppConfiguration
public class InventoryControllerTest {

	MockMvc mockMvc;
	
	@Autowired
	private IntentoryController inventoryController;
	
	@Mock
	private InventoryService inventoryService;

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		when(inventoryService.getAllInventory()).thenReturn(getInventoryDtoList());
		when(inventoryService.getInventory(Mockito.anyInt())).thenReturn(getInventoryDto());
		when(inventoryService.getAllInventoryByProductAttribute(Mockito.anyInt())).thenReturn(getInventoryDtoList());
		when(inventoryService.getAllInventoryByWarehouse(Mockito.anyInt())).thenReturn(getInventoryDtoList());
		//Mockito.doNothing().when(inventoryService).deleteInventory(Mockito.anyInt());
		when(inventoryService.saveInventory(Mockito.any(), Mockito.anyInt())).thenReturn(getInventory());
		when(inventoryService.updateInventory(Mockito.any())).thenReturn(getInventory());
		
		ReflectionTestUtils.setField(inventoryController,"inventoryService", inventoryService);
	}
	
	@Test
	public void getAllIntentory() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/inventory/")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void getIntentoryById() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/inventory/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void getIntentoryByProductAttribute() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/inventory/productAttribute/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void getIntentoryByWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/inventory/warehouse/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	
	@Test
	public void deleteIntentory() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/inventory/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void saveIntentory() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/inventory/")
			      .content(asJsonString(getInventoryDto()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void updateIntentory() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .put("/inventory/")
			      .content(asJsonString(getInventoryDto()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
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
	
	public List<InventoryDto> getInventoryDtoList()
	{
		InventoryDto inventoryDto = new InventoryDto();
		inventoryDto.setId(1);
		inventoryDto.setAvailableQuantity(10);
		inventoryDto.setInStock(15);
		inventoryDto.setInTransit(20);
		inventoryDto.setProductAttributeId(1);
		inventoryDto.setWarehouseId(1);
		
		List<InventoryDto> inventoryDtoList = new ArrayList<InventoryDto>();
		inventoryDtoList.add(inventoryDto);
		return inventoryDtoList;
	}
}
