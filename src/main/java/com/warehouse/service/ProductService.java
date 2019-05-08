package com.warehouse.service;

import java.util.List;

import com.warehouse.Dto.ProductDto;
import com.warehouse.model.Product;

public interface ProductService {
	public List<ProductDto> getAllProduct();
	public ProductDto getProduct(Integer productId);
	public Product saveProduct(ProductDto productDto, Integer attributeDetailId, Integer productAttributeId);
	public Product updateProduct(ProductDto productDto, Integer attributeDetailId, Integer productAttributeId);
	public String deleteProduct(Integer productId);
}
