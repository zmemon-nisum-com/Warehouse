package com.warehouse.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;


/**
 * The persistent class for the brands database table.
 * 
 */
@Entity
@Table(name="brands")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="brand_group")
	private String brandGroup;

	@Column(name="brand_name")
	private String brandName;

	@Column(name="created_at")
	private String createdAt;

	@Column(name="update_at")
	private String updateAt;

	//bi-directional many-to-one association to Company
    @ManyToOne
	private Company company;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="brand")
	private Set<Product> products;

    public Brand() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandGroup() {
		return this.brandGroup;
	}

	public void setBrandGroup(String brandGroup) {
		this.brandGroup = brandGroup;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(String updateAt) {
		this.updateAt = updateAt;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}