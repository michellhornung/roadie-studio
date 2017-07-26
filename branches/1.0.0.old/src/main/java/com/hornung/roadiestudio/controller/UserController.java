package com.hornung.roadiestudio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping
	public String list() {
		return "/user/UserList";
	}
	
	@RequestMapping("/new")
	public String novo() {
		return "/user/NewUser";
	}
	
	
}
