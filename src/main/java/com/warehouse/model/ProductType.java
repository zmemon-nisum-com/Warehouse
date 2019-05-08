package com.warehouse.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;


/**
 * The persistent class for the product_type database table.
 * 
 */
@Entity
@Table(name="product_type")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="product_type")
	private String productType;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="productType")
	private Set<Product> products;

    public ProductType() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductType() {
		return this.productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}