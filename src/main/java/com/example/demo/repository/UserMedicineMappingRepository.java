package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserMedicineMapping;

public interface UserMedicineMappingRepository extends JpaRepository<UserMedicineMapping, Long>{

	List<UserMedicineMapping> findByUserIdAndIsActiveTrue(Long userId);
}
