package com.hornung.roadiestudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hornung.roadiestudio.model.User;
import com.hornung.roadiestudio.repository.Users;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	private Users users;
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("/user/UserList");
		List<User> allUsers = users.findAll();
		mv.addObject("allUsers", allUsers);
		return mv;
	}
	
	@RequestMapping("/new")
	public String novo() {
		return "/user/NewUser";
	}
	
	
}
