package com.hornung.roadiestudio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hornung.roadiestudio.model.RoleType;
import com.hornung.roadiestudio.model.User;
import com.hornung.roadiestudio.repository.RolesType;
import com.hornung.roadiestudio.repository.Users;
import com.hornung.roadiestudio.service.UserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	private Users users;
	
	@Autowired 
	private RolesType rolesType;
	
	@Autowired
	private UserService newUserService;
	
	@RequestMapping
	public ModelAndView usersList() {
		ModelAndView mv = new ModelAndView("/user/UserList");
		List<User> allUsers = users.findAll();
		mv.addObject("allUsers", allUsers);
		return mv;
	}
	
	@RequestMapping("/new")
	public ModelAndView newUser(User user) {
		ModelAndView mv = new ModelAndView("/user/NewUser");
		List<RoleType> roles = rolesType.findAll();
		mv.addObject("allRoles", roles);
		return mv;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView save(@Valid User user, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return newUser(user);
		}
		newUserService.save(user);
		attributes.addFlashAttribute("message", "Usuário salvo com sucesso!");
		return new ModelAndView("redirect:/user/new");
		
	}
	
	/*@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(String codUser, BindingResult result, RedirectAttributes attributes){
		
		newUserService.deleteUserById(Long.parseLong(codUser));
		attributes.addFlashAttribute("message", "Usuário" + "'" + codUser + "'" + " salvo com sucesso!");
		return new ModelAndView("redirect:/user/new");
	}
	*/
	@RequestMapping("/user/delete/{codUser}")
	public String delete(@RequestParam int codUser, BindingResult result, RedirectAttributes attributes) {
		
		newUserService.delete(codUser);
		attributes.addFlashAttribute("message", "Usuário" + "'" + codUser + "'" + " salvo com sucesso!");
		return "redirect:/user/new";
	
	}
	
}
