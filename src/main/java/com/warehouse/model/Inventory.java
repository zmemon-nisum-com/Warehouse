package com.warehouse.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the inventory database table.
 * 
 */
@Entity
@Table(name="inventory")
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="available_quantity")
	private int availableQuantity;

	@Column(name="created_at")
	private String createdAt;

	@Column(name="in_stock")
	private int inStock;

	@Column(name="in_transit")
	private int inTransit;

	@Column(name="updated_at")
	private String updatedAt;

	//bi-directional many-to-one association to ProductAttribute
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="product_attribute_id")
	private ProductAttribute productAttribute;

	//bi-directional many-to-one association to Warehouse
	@ManyToOne
	private Warehouse warehouse;

    public Inventory() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getInStock() {
		return this.inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public int getInTransit() {
		return this.inTransit;
	}

	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public ProductAttribute getProductAttribute() {
		return this.productAttribute;
	}

	public void setProductAttribute(ProductAttribute productAttribute) {
		this.productAttribute = productAttribute;
	}
	
	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
}