package com.example.testFrontEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testFrontEnd.model.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	public Users findByMobile(String mobile);
}
