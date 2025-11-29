package com.example.testFrontEnd.service;

import java.util.List;

import com.example.testFrontEnd.requestResponse.MedicineRequest;
import com.example.testFrontEnd.requestResponse.MedicineResponse;

//@Service
public interface MedicineService {

	public List<MedicineResponse> getAllMedicines();
	public Object getAllMedicinesObject();
	public Object saveData(MedicineRequest request);
}
