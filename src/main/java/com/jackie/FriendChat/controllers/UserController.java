package com.jackie.FriendChat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jackie.FriendChat.models.User;
import com.jackie.FriendChat.models.validators.UserLogin;
import com.jackie.FriendChat.models.validators.UserUpdate;
import com.jackie.FriendChat.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newLogin", new UserLogin());
		return "index.jsp";
	}
	
	@GetMapping("/user/signup")
	public String signup(Model model) {
		model.addAttribute("newUser", new User());
		return "register.jsp";
	}

	

//Login in ....................................................
	@PostMapping("/user/login")
	public String login(
			@Valid
			@ModelAttribute("newLogin") UserLogin newLogin,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		
		User user = userServ.login(newLogin, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/chat";
	}
	
	
//Register.......................................................
	@PostMapping("/user/register")
	public String register(
			@Valid
			@ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		
		userServ.register(newUser, result);
		
		if(result.hasErrors()) {
			return "register.jsp";
		}
		
		session.setAttribute("userId", newUser.getId());
		return "redirect:/";
	}
	
//Logout...........................................................
	@GetMapping("/user/logout")
	public String logout(HttpSession session) {
	  	session.setAttribute("userId", null);
	  	return "redirect:/";
  }
	

//takes us to the User information to update
	@GetMapping("/user/info/{id}")
	public String editUser(
			Model model,
			@PathVariable("id") Long idToEdit,
			HttpSession session) {
		model.addAttribute("userInfo", this.userServ.findbyID(idToEdit));
		return "userInfo.jsp";
	}
	
	
	
//Update the User's information
	@PostMapping("/user/info/{id}")
	public String updateUser(
			@Valid
			@ModelAttribute("userInfo") UserUpdate updateUser,
			@PathVariable("id") Long idToEdit,
			BindingResult result,
			Model model) {
		model.addAttribute("userInfo", this.userServ.findbyID(idToEdit));
		if(result.hasErrors()) {
			return "userInfo.jsp";
		}
		userServ.update(updateUser);
		return "redirect:/chat";
	}
	

	
//testing link
	@GetMapping("/user/info")
	public String Test(
			@ModelAttribute("userInfo") User newUser,
			Model model,
			HttpSession session){
		User user = userServ.findbyID((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "test.jsp";
		
	}
}
