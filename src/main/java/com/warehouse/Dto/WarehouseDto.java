package com.warehouse.Dto;

import com.warehouse.model.Country;

public class WarehouseDto {
	private int id;

	private String address;

	private String createdAt;

	private String updatedAt;

	private String warehouseName;

	private Country country;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	@Override
	public String toString() {
		return "WarehouseDto [id=" + id + ", address=" + address + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", warehouseName=" + warehouseName + "]";
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}	
	
}
