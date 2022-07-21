package com.healthmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthmate.domain.Post;
import com.healthmate.domain.User;
import com.healthmate.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동
	@GetMapping("/auth/login")
	public String login() {
		return "system/login";
	}
	
	//회원가입 화면으로 이동
	@GetMapping("/auth/insertUser")
	public String insertUser() {
		return "user/insertUser";
	}
	
	//회원상세보기
	@GetMapping("/user/updateUser")
	public String updateUser() {
		return "user/updateUser";
	}
	
	
	//회원 가입처리
	@PostMapping("/auth/insertUser")
	public @ResponseBody String insertUser(@RequestBody User user) {
		
		User findUser = userService.getUser(user.getUsername());
		
		if(findUser.getUsername() == null) {
			user.setRole("USER");
			userService.insertUser(user);
			return user.getUsername() + "회원 가입 성공";
		} else {
			return user.getUsername() + "아이디는 이미 존재합니다.";
		}
		
	}
	
	
	
}
