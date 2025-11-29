package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MedicineMaster;
import com.example.demo.model.UserMedicineMapping;
import com.example.demo.model.Users;
import com.example.demo.repository.MedicineMasterRepo;
import com.example.demo.repository.UserMedicineMappingRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.requestResponse.CommonResponse;
import com.example.demo.requestResponse.MedicineRequest;
import com.example.demo.requestResponse.MedicineResponse;
import com.example.demo.service.MedicineService;

import aj.org.objectweb.asm.commons.Method;

@Service
public class MedicineServiceImpl implements MedicineService {

	Logger logger = LoggerFactory.getLogger(MedicineServiceImpl.class);

	@Autowired
	public MedicineMasterRepo repo;

	@Autowired
	public UserRepository userRepo;

	@Autowired
	public UserMedicineMappingRepository mappingRepo;

	@Override
	public List<MedicineResponse> getAllMedicines() {
		try {
			List<MedicineMaster> list = repo.findAll();
			List<MedicineResponse> resposneList = new ArrayList();
			BeanUtils.copyProperties(list, resposneList);
			return resposneList;
		} catch (Exception e) {
			logger.info("Error : [{}]", e);
			return null;
		}
	}

	@Override
	public Object getAllMedicinesObject() {
		return repo.findAll();
	}
	
	private String test() {
		try {
			Users uu=new Users();
			java.lang.reflect.Method data = Users.class.getMethod("setEmail", String.class);
			data.invoke(uu, "abc");
			userRepo.save(uu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public Object saveData(MedicineRequest req) {
		try {
			
			test();
			
			Users users = null;
			users = userRepo.findByMobileAndIsActiveTrue(String.valueOf(req.getMobile()));
			if (users == null) {
				users = new Users();
				users.setIsActive(true);
				users.setCreatedDate(new Date());
				users.setModifiedDate(new Date());
			}
			BeanUtils.copyProperties(req, users, "userId");
			users.setIsActive(true);
			users.setModifiedDate(new Date());
			users.setFutureAppointment(calculateFutureDate(req.getNextAppointment()));
			Users savedUser = userRepo.saveAndFlush(users);
			savedUser.setUserId(savedUser.getId());
			userRepo.save(savedUser);

			List<UserMedicineMapping> userMapping = mappingRepo.findByUserIdAndIsActiveTrue(savedUser.getUserId());
			userMapping.forEach(e -> {
				e.setIsActive(false);
				e.setModifiedDate(new Date());
				mappingRepo.save(e);
			});

			if (req.getMedicineDetails() != null && req.getMedicineDetails().size() > 0) {
				for (int i = 0; i < req.getMedicineDetails().size(); i++) {
					UserMedicineMapping mapping = new UserMedicineMapping();
					mapping.setUserId(savedUser.getId());
					mapping.setMedicineId(req.getMedicineDetails().get(i).getId());
					mapping.setIsActive(true);
					mapping.setCreatedDate(new Date());
					mapping.setModifiedDate(new Date());
					mapping.setQuentity(req.getMedicineDetails().get(i).getQuantity().longValue());
					mapping.setDuration(req.getMedicineDetails().get(i).getDuration());
					mappingRepo.save(mapping);
				}
			}

			return savedUser;
		} catch (Exception e) {
			System.out.println(e);
			return 500;
		}
	}

	private String calculateFutureDate(Integer days) {
		try {
			LocalDate currentDate = LocalDate.now();
			LocalDate futureDate = currentDate.plusDays(days);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedFutureDate = futureDate.format(formatter);
			return formattedFutureDate;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<MedicineRequest> getAllUsers() {
		List<Users> list = userRepo.getAllAndIsActiveTrue();
		List<MedicineRequest> req = list.stream().map(user -> {
			MedicineRequest obj = new MedicineRequest();
			BeanUtils.copyProperties(user, obj);
			return obj;
		}).collect(Collectors.toList());
		return req;
	}

	@Override
	public Object deleteUser(MedicineRequest request) {
		try {
			Users users = userRepo.findById(request.getId()).orElse(null);
			users.setIsActive(false);
			userRepo.save(users);
			logger.info("User Delete Successfully...." + users.getPatientName());
			return new CommonResponse(200, "Successfully remove user", users.getPatientName());
		} catch (Exception e) {
			logger.info("Error while delete user : [{}]", e);
			return new CommonResponse(500, "Something went wrong..", 500);
		}
	}

	@Override
	public List<MedicineRequest> getSearchedUsers(MedicineRequest request) {
		if(request.getSelectedSearchType() == 1) {
			List<Users> list = userRepo.getAllByPatientName(request.getSearchData());
			List<MedicineRequest> req = list.stream().map(user -> {
				MedicineRequest obj = new MedicineRequest();
				BeanUtils.copyProperties(user, obj);
				return obj;
			}).collect(Collectors.toList());
			return req;
		} else {
			List<Users> list = userRepo.getAllBymobile(request.getSearchData());
			List<MedicineRequest> req = list.stream().map(user -> {
				MedicineRequest obj = new MedicineRequest();
				BeanUtils.copyProperties(user, obj);
				return obj;
			}).collect(Collectors.toList());
			return req;
		}
	}

}
