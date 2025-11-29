package com.example.testFrontEnd.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generate ID
	@Column(name = "id")
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "is_active")
	private Boolean isActive; // `bit(1)` maps to `Boolean` in Java

	@Column(name = "password")
	private String password;

    @Column(name = "user_id")
	private Long userId;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "gender")
	private String gender;

	@Column(name = "medicine_list", columnDefinition = "TEXT")
	private String medicineList; // `longtext` maps to `String` in Java
	
	@Column(name = "patient_name")
	private String patientName; 

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMedicineList() {
		return medicineList;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setMedicineList(String medicineList) {
		this.medicineList = medicineList;
	}
}
