package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@SuppressWarnings("serial")
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

	@Column(name = "medicine_list")
	private String medicineList;
	
	@Column(name = "patient_name")
	private String patientName; 

	@Column(name = "age")
	private Integer age; 

	@Column(name = "created_date")
	private Date createdDate; 

	@Column(name = "modified_date")
	private Date modifiedDate; 
	
	@Column(name = "co")
	private String co; 
	
	@Column(name = "dx")
	private String dx; 
	
	@Column(name = "next_appointment")
	private Integer nextAppointment; 
	
	@Column(name = "future_appointment")
	private String futureAppointment; 
	
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

	public Integer getAge() {
		return age;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getDx() {
		return dx;
	}

	public void setDx(String dx) {
		this.dx = dx;
	}

	public Integer getNextAppointment() {
		return nextAppointment;
	}

	public void setNextAppointment(Integer nextAppointment) {
		this.nextAppointment = nextAppointment;
	}

	public String getFutureAppointment() {
		return futureAppointment;
	}

	public void setFutureAppointment(String futureAppointment) {
		this.futureAppointment = futureAppointment;
	}

}
