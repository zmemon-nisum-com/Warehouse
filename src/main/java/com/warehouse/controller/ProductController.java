package com.warehouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warehouse.Dto.ProductDto;
import com.warehouse.exception.WarehouseException;
import com.warehouse.model.Product;
import com.warehouse.service.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<ProductDto> getAllProduct() throws WarehouseException {
		List<ProductDto> productDtoList = productService.getAllProduct();
		
		return productDtoList;
	}
	
	@GetMapping("/{productId}")
	public ProductDto getProduct(@PathVariable Integer productId) throws WarehouseException {
		ProductDto productDto = productService.getProduct(productId);
		
		return productDto;
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Integer productId) throws WarehouseException {
		productService.deleteProduct(productId);

		return "Product Deleted";
	}
	
	@PostMapping("/")
	public Product saveProduct(@RequestBody ProductDto productDto) throws WarehouseException {
		Product savedProduct = productService.saveProduct(productDto, productDto.getAttributeId(), productDto.getProductAttributeId());
		
		return savedProduct;
	}
	
	@PutMapping("/")
	public Product updateProduct(@RequestBody ProductDto productDto) throws WarehouseException {
		Product updatedProduct = productService.updateProduct(productDto, productDto.getAttributeId(), productDto.getProductAttributeId());
		
		return updatedProduct;
	}
	
}
