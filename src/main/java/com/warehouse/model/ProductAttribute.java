package com.warehouse.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the product_attribute database table.
 * 
 */
@Entity
@Table(name="product_attribute")
public class ProductAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="created_at")
	private String createdAt;

	@Column(name="updated_at")
	private String updatedAt;

	//bi-directional many-to-one association to Inventory
	@JsonIgnore
	@OneToMany(mappedBy="productAttribute")
	private Set<Inventory> inventories;

	//bi-directional many-to-one association to AttributesDetail
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="attribute_detail_id")
	private AttributesDetail attributesDetail;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;

    public ProductAttribute() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}
	
	public AttributesDetail getAttributesDetail() {
		return this.attributesDetail;
	}

	public void setAttributesDetail(AttributesDetail attributesDetail) {
		this.attributesDetail = attributesDetail;
	}
	
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}