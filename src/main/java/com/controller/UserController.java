package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;

@Controller
public class UserController {
    @GetMapping("/newUser")
    public String newUser() {
        return "NewUser";  // This should match the JSP file name
    }
	
	@PostMapping("/Saveuser")
	public String saveUser(UserEntity user) {
		System.out.println("First Name: " + user.getFirstName());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Password: " + user.getPassword());
		return "NewUser";
	}
}
