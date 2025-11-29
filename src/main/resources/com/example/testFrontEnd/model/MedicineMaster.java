package com.example.testFrontEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicine_master")
public class MedicineMaster {
    
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "price", nullable = false)
    private String price;
    
    @Column(name = "is_discontinued", nullable = false)
    private boolean isDiscontinued;
    
    @Column(name = "manufacturer_name", nullable = false)
    private String manufacturerName;
    
    @Column(name = "type", nullable = false)
    private String type;
    
    @Column(name = "pack_size_label", nullable = false)
    private String packSizeLabel;
    
    @Column(name = "short_composition1", nullable = false)
    private String shortComposition1;
    
    @Column(name = "short_composition2", nullable = false)
    private String shortComposition2;
    
    @Column(name = "is_active", nullable = false)
    private String isActive;

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isDiscontinued() {
		return isDiscontinued;
	}

	public void setDiscontinued(boolean isDiscontinued) {
		this.isDiscontinued = isDiscontinued;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPackSizeLabel() {
		return packSizeLabel;
	}

	public void setPackSizeLabel(String packSizeLabel) {
		this.packSizeLabel = packSizeLabel;
	}

	public String getShortComposition1() {
		return shortComposition1;
	}

	public void setShortComposition1(String shortComposition1) {
		this.shortComposition1 = shortComposition1;
	}

	public String getShortComposition2() {
		return shortComposition2;
	}

	public void setShortComposition2(String shortComposition2) {
		this.shortComposition2 = shortComposition2;
	}
    
}