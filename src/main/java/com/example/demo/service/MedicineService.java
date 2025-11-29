package com.example.demo.service;

import java.util.List;

import com.example.demo.requestResponse.MedicineRequest;
import com.example.demo.requestResponse.MedicineResponse;

//@Service
public interface MedicineService {

	public List<MedicineResponse> getAllMedicines();
	public Object getAllMedicinesObject();
	public Object saveData(MedicineRequest request);
	public List<MedicineRequest> getAllUsers();
	public Object deleteUser(MedicineRequest request);
	public List<MedicineRequest> getSearchedUsers(MedicineRequest request);
}
