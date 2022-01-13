package com.example.SpringBootLoginRegistrationLogoutApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringBootLoginRegistrationLogoutApplication.dao.UserDao;
import com.example.SpringBootLoginRegistrationLogoutApplication.model.UserModel;

@Controller
public class LoginRegistrationController {
	
	@Autowired
	public UserDao userDao;
	
	@RequestMapping("/")
	public String startApplcation() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "registration";
	}
	
	
	@RequestMapping("/insert")
	public String registerNewUser(UserModel userModel, Model model) {
		userDao.save(userModel);
		model.addAttribute("msg", "user registration successful");
		return "login";
	}
	
	@RequestMapping("/validate")
	public String validateUser(UserModel userModel, Model model) {
		System.out.println(userModel.toString());
		List<UserModel> byNameAndPaword = userDao.getByNameAndPaword(userModel.getName(), userModel.getPassword());
		if(byNameAndPaword.isEmpty() || byNameAndPaword == null) {
			model.addAttribute("msg", "Login Failed");
			return "login";
		}else {
			model.addAttribute("user", byNameAndPaword.get(0));
			return "home";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "login";
	}
}
