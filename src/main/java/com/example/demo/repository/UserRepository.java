package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByMobileAndIsActiveTrue(String mobile);

	@Query(value = "from Users where isActive=true")
	public List<Users> getAllAndIsActiveTrue();
	
	@Query(value = "from Users where isActive=true AND patientName LIKE (%:name%)")
	public List<Users> getAllByPatientName(@Param("name") String name);
	
	@Query(value = "from Users where isActive=true AND mobile =:mobile")
	public List<Users> getAllBymobile(@Param("mobile") String mobile);
}
