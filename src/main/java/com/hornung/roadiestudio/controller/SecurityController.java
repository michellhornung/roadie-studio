package com.hornung.roadiestudio.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings("deprecation")
@Controller
public class SecurityController {

	@RequestMapping("/login")
	public String Login(@AuthenticationPrincipal User user) {
		if (user != null) {
			return ("redirect:/user");
		}
		
		return "Login";
	}
	
}
