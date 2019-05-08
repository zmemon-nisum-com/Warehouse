package com.warehouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warehouse.Dto.ProductDto;
import com.warehouse.model.AttributesDetail;
import com.warehouse.model.Product;
import com.warehouse.model.ProductAttribute;
import com.warehouse.repository.AttributeDetailRepository;
import com.warehouse.repository.ProductAttributeReposiroty;
import com.warehouse.repository.ProductRepository;
import com.warehouse.utill.ProductUtil;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductAttributeReposiroty productAttributeReposiroty;
	
	@Autowired
	private AttributeDetailRepository attributeDetailReposiroty;
	
	@Autowired
	private ProductUtil productUtil;
	
	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> productList = productRepository.findAll();
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		for(Product product:productList)
		{
			productDtoList.add(productUtil.convertProducttoProductDto(product));
		}
		
		return productDtoList;
	}

	@Override
	public ProductDto getProduct(Integer productId) {
		Optional<Product> product = productRepository.findById(productId);
		ProductDto productDto = productUtil.convertProducttoProductDtoo(product);

		return productDto;
	}

	@Override
	public Product saveProduct(ProductDto productDto, Integer attributeDetailId, Integer productAttributeId) {
		Product product = productUtil.convertProductDtotoProduct(productDto);
		
		Product savedProduct = productRepository.save(product);
		Product lastProduct = productRepository.findFirstByOrderByIdDesc();
		
		Optional<AttributesDetail> attributesDetail = attributeDetailReposiroty.findById(attributeDetailId);
		
		ProductAttribute productAttribute = new ProductAttribute();
		if(productAttributeId != null)
		{
			productAttribute.setId(productAttributeId);
		}
		productAttribute.setProduct(lastProduct);
		productAttribute.setAttributesDetail(attributesDetail.get());
		
		productAttributeReposiroty.save(productAttribute);
		
		return savedProduct;
	}

	@Override
	public Product updateProduct(ProductDto productDto, Integer attributeDetailId, Integer productAttributeId) {
		Product product = productUtil.convertProductDtotoProduct(productDto);
		
		Product updatedProduct = productRepository.save(product);
		
		Optional<AttributesDetail> attributesDetail = attributeDetailReposiroty.findById(attributeDetailId);
		
		ProductAttribute productAttribute = new ProductAttribute();
		if(productAttributeId != null)
		{
			productAttribute.setId(productAttributeId);
		}
		productAttribute.setProduct(updatedProduct);
		productAttribute.setAttributesDetail(attributesDetail.get());
		
		productAttributeReposiroty.save(productAttribute);
		return updatedProduct;
	}

	@Override
	public String deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
		return "Product Deleted";
	}

}
