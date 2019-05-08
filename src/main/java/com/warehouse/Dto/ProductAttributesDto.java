package com.warehouse.Dto;

public class ProductAttributesDto {
	
	private int id;

	private String createdAt;

	private String updatedAt;

	private AttributesDetailDto attributesDetailDto;

	private ProductDto productDto;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public AttributesDetailDto getAttributesDetailDto() {
		return attributesDetailDto;
	}

	public void setAttributesDetailDto(AttributesDetailDto attributesDetailDto) {
		this.attributesDetailDto = attributesDetailDto;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	
}
