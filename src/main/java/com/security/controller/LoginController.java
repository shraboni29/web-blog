package com.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.commandform.UserCommandForm;
import com.security.entity.Authorities;
import com.security.entity.Users;
import com.security.service.UserService;

@Controller
public class LoginController {
	@Autowired
	public UserService userService;

	@PostMapping("/authenticateTheUser")
	public String showpage() {
		return "redirect:/home";
	}

	@GetMapping("/showLogin")
	public String showlogin() {
		return "login";
	}

	@GetMapping("/addUser")
	public String showRegistrationPage(Model model)

	{

		UserCommandForm uForm = new UserCommandForm();
		model.addAttribute("users1", uForm);

		return "registration";
	}

	@GetMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("users1") UserCommandForm u1, BindingResult bindingResult,
			Model model)

	{
		String username = u1.getUsername();
		String email = u1.getEmail();

		// Authorities a1=new Authorities();
		// saveuserImp(UserCommandForm u1)
		if (bindingResult.hasErrors()) {
			return "registration";

		}
		Users exist = userService.findByUserName(username);
		if (exist != null) {
			model.addAttribute("users", new UserCommandForm());
			model.addAttribute("UserNameError", "User name already exists.");

			return "registration";
		}
		Users existEmail = userService.findByEmail(email);
		if (existEmail != null) {
			model.addAttribute("users", new UserCommandForm());
			model.addAttribute("EmailError", "Email already exists.");

			return "registration";
		}

		userService.saveuserImp(u1);

		return "redirect:/home";

	}

}
