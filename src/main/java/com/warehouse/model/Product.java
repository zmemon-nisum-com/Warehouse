package com.warehouse.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id //@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="created_at")
	private String createdAt;

	@Column(name="MOQ")
	private int moq;

	@Column(name="price")
	private String price;

	@Column(name="product_description")
	private String productDescription;

	@Column(name="product_name")
	private String productName;

	@Column(name="QPB")
	private int qpb;

	@Column(name="reorder_point")
	private int reorderPoint;

	@Column(name="updated_at")
	private String updatedAt;

	//bi-directional many-to-one association to Brand
    @JsonIgnore
	@ManyToOne
	private Brand brand;

	//bi-directional many-to-one association to ProductType
    @JsonIgnore
    @ManyToOne
	@JoinColumn(name="product_type_id")
	private ProductType productType;

	//bi-directional many-to-one association to ProductAttribute
    @OneToMany(mappedBy="product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ProductAttribute> productAttributes;

    public Product() {
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

	public int getMoq() {
		return this.moq;
	}

	public void setMoq(int moq) {
		this.moq = moq;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQpb() {
		return this.qpb;
	}

	public void setQpb(int qpb) {
		this.qpb = qpb;
	}

	public int getReorderPoint() {
		return this.reorderPoint;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public Set<ProductAttribute> getProductAttributes() {
		return this.productAttributes;
	}

	public void setProductAttributes(Set<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}
	
}