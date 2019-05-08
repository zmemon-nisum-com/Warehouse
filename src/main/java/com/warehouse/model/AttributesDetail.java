package com.warehouse.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the attributes_detail database table.
 * 
 */
@Entity
@Table(name="attributes_detail")
public class AttributesDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="attribute_detail")
	private String attributeDetail;

	//bi-directional many-to-one association to Attribute
    @ManyToOne
	private Attribute attribute;

	//bi-directional many-to-one association to ProductAttribute
	@OneToMany(mappedBy="attributesDetail")
	private Set<ProductAttribute> productAttributes;

    public AttributesDetail() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttributeDetail() {
		return this.attributeDetail;
	}

	public void setAttributeDetail(String attributeDetail) {
		this.attributeDetail = attributeDetail;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}
	
	public Set<ProductAttribute> getProductAttributes() {
		return this.productAttributes;
	}

	public void setProductAttributes(Set<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}
	
}