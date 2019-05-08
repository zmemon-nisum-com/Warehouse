package com.warehouse.utill;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.warehouse.Dto.ProductDto;
import com.warehouse.model.Brand;
import com.warehouse.model.Product;
import com.warehouse.model.ProductType;

@Component
public class ProductUtil {
	
	public Product convertProductDtotoProduct(ProductDto productDto)
	{
		Product product = new Product();
		product.setId(productDto.getId());
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());
		product.setProductDescription(productDto.getProductDescription());
		Brand brand = new Brand();
		brand.setId(productDto.getBrandId());
		product.setBrand(brand);
		product.setMoq(productDto.getMoq());
		product.setQpb(productDto.getQpb());
		product.setReorderPoint(productDto.getReorderPoint());
		product.setCreatedAt(productDto.getCreatedAt());
		product.setUpdatedAt(productDto.getUpdatedAt());
		ProductType productType = new ProductType();
		productType.setId(productDto.getProductTypeId());
		product.setProductType(productType);
		//product.setProductAttributes(productDto.getProductAttributes());
		
		return product;
	}
	
	public ProductDto convertProducttoProductDto(Product product)
	{
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setProductName(product.getProductName());
		productDto.setPrice(product.getPrice());
		productDto.setProductDescription(product.getProductDescription());
		productDto.setBrandId(product.getBrand().getId());
		productDto.setMoq(product.getMoq());
		productDto.setQpb(product.getQpb());
		productDto.setReorderPoint(product.getReorderPoint());
		productDto.setCreatedAt(product.getCreatedAt());
		productDto.setUpdatedAt(product.getUpdatedAt());
		productDto.setProductTypeId(product.getProductType().getId());
		//productDto.setProductAttributes(product.getProductAttributes());
		
		return productDto;
	}


	public ProductDto convertProducttoProductDtoo(Optional<Product> product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.get().getId());
		productDto.setProductName(product.get().getProductName());
		productDto.setPrice(product.get().getPrice());
		productDto.setProductDescription(product.get().getProductDescription());
		productDto.setBrandId(product.get().getBrand().getId());
		productDto.setMoq(product.get().getMoq());
		productDto.setQpb(product.get().getQpb());
		productDto.setReorderPoint(product.get().getReorderPoint());
		productDto.setCreatedAt(product.get().getCreatedAt());
		productDto.setUpdatedAt(product.get().getUpdatedAt());
		productDto.setProductTypeId(product.get().getProductType().getId());
		//productDto.setProductAttributes(product.get().getProductAttributes());
		
		return productDto;
		
	}
}
