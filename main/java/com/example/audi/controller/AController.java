package com.example.audi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.audi.model.User;
import com.example.audi.repo.UserRepo;

@RestController
public class AController {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/users")
	public void save(@RequestBody User user) {
		String encodedPassword=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
	}
	@GetMapping("/aa")
	public String aa() {
		return "user aa string";
	}
	@GetMapping("/admin")
	public String bb() {
		return "admin stirng";
	}
	@GetMapping("/cc")
	public String cc() {
		return "user cc string";
	}

}

// jack password jack jill passsword jill