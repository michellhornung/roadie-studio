package com.hornung.roadiestudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hornung.roadiestudio.model.RoleType;
import com.hornung.roadiestudio.model.User;
import com.hornung.roadiestudio.repository.Users;
import com.hornung.roadiestudio.service.NewUserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	private Users users;
	
	@Autowired
	private NewUserService newUserService;
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("/user/UserList");
		List<User> allUsers = users.findAll();
		mv.addObject("allUsers", allUsers);
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView newUser(User user) {
		ModelAndView mv = new ModelAndView("/user/NewUser");
		mv.addObject("roles", RoleType.values());
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(User user) {
		newUserService.save(user);
		return new ModelAndView("Redirect:/user/new");
		
	}
	
}
