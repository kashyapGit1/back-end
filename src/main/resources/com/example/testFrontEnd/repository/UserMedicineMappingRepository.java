package com.example.testFrontEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testFrontEnd.model.UserMedicineMapping;

public interface UserMedicineMappingRepository extends JpaRepository<UserMedicineMapping, Long>{

	List<UserMedicineMapping> findByUserId(Long userId);
}
