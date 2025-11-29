package com.example.testFrontEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.testFrontEnd.requestResponse.CommonResponse;
import com.example.testFrontEnd.requestResponse.MedicineRequest;
import com.example.testFrontEnd.service.MedicineService;

@RestController
public class Controller {

	@Autowired
	public MedicineService medicineService;

	@GetMapping(path = "/getAllMedicines", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllMedicinesList() {
		return medicineService.getAllMedicinesObject();
	}

	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST })
	@PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> saveMedicine(@RequestBody MedicineRequest request) {
		return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),"successfully save user",medicineService.saveData(request)),HttpStatus.OK);
	}

}