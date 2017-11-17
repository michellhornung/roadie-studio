package com.hornung.roadiestudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hornung.roadiestudio.model.User;

public interface Users extends JpaRepository<com.hornung.roadiestudio.model.User, Integer>{

	User findByUsernameAndPassword(String username, String password);
	
}