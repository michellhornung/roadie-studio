package com.hornung.roadiestudio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hornung.roadiestudio.model.User;
import com.hornung.roadiestudio.repository.Users;

@Service
public class NewUserService {
	
	@Autowired
	private Users users;
	
	public void save(User user){

		//TODO regras de negócio
		this.users.save(user);
	}

}
