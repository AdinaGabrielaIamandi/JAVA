package com.spring_mvct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.spring_mvct.model.User;

@Controller
public class FormController {

	@GetMapping("/register")
	public ModelAndView showFromRegister() {
		return new ModelAndView("register", "userRegister", new User());
	}

	@PostMapping("/register")
	public @ResponseBody String submit(@ModelAttribute("userRegister") User userRegister, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("ERRORE");
		} else {
		System.out.println(userRegister);
		}
		return "Method post submit";
	}

}
