package com.example.demo.requestResponse;

import java.util.List;

public class MedicineRequest {

	private Long id;
	private String patientName;
	private String email;
	private Boolean isActive; // `bit(1)` maps to `Boolean` in Java
	private String password;
	private Long userId;
	private String mobile;
	private String gender;
	private Integer age;
	private Integer quantity;
	private String co;
	private String dx;
	private Integer nextAppointment;
	private List<MedicineDetails> medicineDetails;
	private Integer selectedSearchType;
	private String searchData;
	
	
	public Integer getSelectedSearchType() {
		return selectedSearchType;
	}
	public void setSelectedSearchType(Integer selectedSearchType) {
		this.selectedSearchType = selectedSearchType;
	}
	public String getSearchData() {
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public List<MedicineDetails> getMedicineDetails() {
		return medicineDetails;
	}
	public void setMedicineDetails(List<MedicineDetails> medicineDetails) {
		this.medicineDetails = medicineDetails;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
