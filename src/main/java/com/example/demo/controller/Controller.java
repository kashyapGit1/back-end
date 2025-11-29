package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.requestResponse.CommonResponse;
import com.example.demo.requestResponse.MedicineRequest;
import com.example.demo.service.MedicineService;

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
	
	@GetMapping(path = "/getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET })
	public ResponseEntity<CommonResponse> getAllUsers() {
		return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),"successfully get users",medicineService.getAllUsers()),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST })
	@PostMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> deleteUser(@RequestBody MedicineRequest request) {
		return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),"User Delete Successfully..",medicineService.deleteUser(request)),HttpStatus.OK);
	}
	
	@PostMapping(path = "/searchUsers",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.POST })
	public ResponseEntity<CommonResponse> searchUsers(@RequestBody MedicineRequest request) {
		if(request == null || request.getSelectedSearchType() == null || request.getSearchData() == null) {
			return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),"Required Field Missing...","Error 1003"),HttpStatus.OK);
		} else {			
			return new ResponseEntity<>(new CommonResponse(HttpStatus.OK.value(),"",medicineService.getSearchedUsers(request)),HttpStatus.OK);
		}
	}
	

}