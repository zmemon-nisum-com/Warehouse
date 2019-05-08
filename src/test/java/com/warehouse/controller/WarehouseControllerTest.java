package com.warehouse.controller;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouse.Dto.WarehouseDto;
import com.warehouse.config.WebMvcConfig;
import com.warehouse.model.Country;
import com.warehouse.model.Warehouse;
import com.warehouse.service.WarehouseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcConfig.class})
@WebAppConfiguration
public class WarehouseControllerTest {
	
	MockMvc mockMvc;
	
	@Autowired
	private WarehouseController warehouseController;
	
	@Mock
	private WarehouseService warehouseService;

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		when(warehouseService.getAllWarehouse()).thenReturn(getWarehouseDtoList());
		when(warehouseService.getWarehouse(Mockito.anyInt())).thenReturn(getWarehouseDto());
		//Mockito.doNothing().when(warehouseService).deleteWarehouse(Mockito.anyInt());
		when(warehouseService.saveWarehouse(Mockito.any())).thenReturn(getWarehouse());
		when(warehouseService.updateWarehouse(Mockito.any())).thenReturn(getWarehouse());
		
		ReflectionTestUtils.setField(warehouseController,"warehouseService", warehouseService);
	}
	
	@Test
	public void getAllWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/warehouse/")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void getWarehouseById() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/warehouse/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void deleteWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/warehouse/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void saveWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/warehouse/")
			      .content(asJsonString(getWarehouseDto()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void updateWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .put("/warehouse/")
			      .content(asJsonString(getWarehouseDto()))
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
	
	public List<WarehouseDto> getWarehouseDtoList()
	{
		WarehouseDto warehouseDto = new WarehouseDto();
		Country country = new Country();
		country.setId(1);
		warehouseDto.setCountry(country);
		warehouseDto.setWarehouseName("Mega");
		
		List<WarehouseDto> warehouseDtoList = new ArrayList<WarehouseDto>();
		warehouseDtoList.add(warehouseDto);
		
		return warehouseDtoList;
	}
}
