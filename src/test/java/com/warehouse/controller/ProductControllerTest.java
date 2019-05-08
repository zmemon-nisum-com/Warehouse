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
import com.warehouse.Dto.ProductDto;
import com.warehouse.config.WebMvcConfig;
import com.warehouse.model.Brand;
import com.warehouse.model.Product;
import com.warehouse.model.ProductType;
import com.warehouse.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebMvcConfig.class})
@WebAppConfiguration
public class ProductControllerTest {
	
	MockMvc mockMvc;
	
	@Autowired
	private ProductController productController;
	
	@Mock
	private ProductService productService;

	@Autowired
	private WebApplicationContext wac;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		
		when(productService.getAllProduct()).thenReturn(getProductDtoList());
		when(productService.getProduct(Mockito.anyInt())).thenReturn(getProductDto());
		//Mockito.doNothing().when(productService).deleteProduct(Mockito.anyInt());
		when(productService.saveProduct(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(getProduct());
		when(productService.updateProduct(Mockito.any(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(getProduct());
		
		ReflectionTestUtils.setField(productController,"productService", productService);
	}
	
	
	@Test
	public void getAllWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/product/")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void getWarehouseById() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .get("/product/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void deleteWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .delete("/product/1")
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void saveWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/product/")
			      .content(asJsonString(getProductDto()))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void updateWarehouse() throws Exception {
		mockMvc.perform( MockMvcRequestBuilders
			      .put("/product/")
			      .content(asJsonString(getProductDto()))
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
	
	public Product getProduct()
	{
		Product product = new Product();
		product.setId(1);
		product.setProductName("Shoe");
		
		Brand brand = new Brand();
		brand.setId(1);
		product.setBrand(brand);
		
		ProductType productType = new ProductType();
		productType.setId(1);
		product.setProductType(productType);
		
		return product;
	}
	
	public List<Product> getProductList()
	{
		Product product = new Product();
		product.setId(1);
		product.setProductName("Shoe");
		product.setMoq(1);
		product.setPrice("200");
		product.setQpb(1);
		product.setReorderPoint(10);
		
		Brand brand = new Brand();
		brand.setId(1);
		product.setBrand(brand);
		
		ProductType productType = new ProductType();
		productType.setId(1);
		product.setProductType(productType);
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		
		return productList;	
	}
	
	public ProductDto getProductDto()
	{
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setProductName("Shoe");
		productDto.setBrandId(1);
		productDto.setProductTypeId(1);
		productDto.setAttributeId(1);
		
		return productDto;
	}
	
	public List<ProductDto> getProductDtoList()
	{
		ProductDto productDto = new ProductDto();
		productDto.setId(1);
		productDto.setProductName("Shoe");
		productDto.setBrandId(1);
		productDto.setProductTypeId(1);
		productDto.setAttributeId(1);
		
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		productDtoList.add(productDto);
		return productDtoList;
	}
}
