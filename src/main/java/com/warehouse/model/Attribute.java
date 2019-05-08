package com.warehouse.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * The persistent class for the attributes database table.
 * 
 */
@Entity
@Table(name="attributes")
public class Attribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="attribute_description")
	private String attributeDescription;

	@Column(name="attribute_label")
	private String attributeLabel;

	@Column(name="created_at")
	private String createdAt;

	@Column(name="updated_at")
	private String updatedAt;

	//bi-directional many-to-one association to AttributesDetail
	@OneToMany(mappedBy="attribute")
	private Set<AttributesDetail> attributesDetails;

    public Attribute() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttributeDescription() {
		return this.attributeDescription;
	}

	public void setAttributeDescription(String attributeDescription) {
		this.attributeDescription = attributeDescription;
	}

	public String getAttributeLabel() {
		return this.attributeLabel;
	}

	public void setAttributeLabel(String attributeLabel) {
		this.attributeLabel = attributeLabel;
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

	public Set<AttributesDetail> getAttributesDetails() {
		return this.attributesDetails;
	}

	public void setAttributesDetails(Set<AttributesDetail> attributesDetails) {
		this.attributesDetails = attributesDetails;
	}
	
}