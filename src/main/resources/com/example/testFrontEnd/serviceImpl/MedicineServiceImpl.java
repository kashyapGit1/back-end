package com.example.testFrontEnd.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testFrontEnd.model.MedicineMaster;
import com.example.testFrontEnd.model.UserMedicineMapping;
import com.example.testFrontEnd.model.Users;
import com.example.testFrontEnd.repository.MedicineMasterRepo;
import com.example.testFrontEnd.repository.UserMedicineMappingRepository;
import com.example.testFrontEnd.repository.UserRepository;
import com.example.testFrontEnd.requestResponse.MedicineRequest;
import com.example.testFrontEnd.requestResponse.MedicineResponse;
import com.example.testFrontEnd.service.MedicineService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class MedicineServiceImpl implements MedicineService{

	Logger logger=LoggerFactory.getLogger(MedicineServiceImpl.class);
	
	@Autowired
	public MedicineMasterRepo repo;
	
	@Autowired
	public UserRepository userRepo;
	

	@Autowired
	public UserMedicineMappingRepository mappingRepo;
	
	@Override
	public List<MedicineResponse> getAllMedicines() {
		try {			
			List<MedicineMaster> list= repo.findAll();
			List<MedicineResponse> resposneList=new ArrayList();
			BeanUtils.copyProperties(list, resposneList);
			return resposneList;
		} catch (Exception e) {
			logger.info("Error : [{}]",e);
			return null;
		}
	}

	@Override
	public Object getAllMedicinesObject() {
		logger.info("test");
		return repo.findAll();
	}

	@Override
	public Object saveData(MedicineRequest req) {
		try {
			Users users=null;
			users = userRepo.findByMobile(String.valueOf(req.getMobile()));
			if(users == null) {				
				users = new Users();
				users.setIsActive(true);
			}
			BeanUtils.copyProperties(req, users,"userId");
			users.setIsActive(true);
			Users savedUser = userRepo.save(users);
			savedUser.setUserId(savedUser.getId());
			userRepo.save(savedUser);
			
			List<UserMedicineMapping> userMapping = mappingRepo.findByUserId(savedUser.getUserId());
			userMapping.forEach(e ->{
				e.setIsActive(false);
				mappingRepo.save(e);
			});
			
			if(req.getMedications() != null && req.getMedications().size() > 0) {
				for (int i = 0; i < req.getMedications().size(); i++) {					
					UserMedicineMapping mapping = new UserMedicineMapping();
					mapping.setUserId(savedUser.getId());
					mapping.setMedicineId(req.getMedications().get(i));
					mapping.setIsActive(true);
					mappingRepo.save(mapping);
				}
			}			
			return 200;
		} catch (Exception e) {
			System.out.println(e);
			return 500;
		}
	}

}
