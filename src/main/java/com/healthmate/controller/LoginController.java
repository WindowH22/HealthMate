package com.healthmate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthmate.domain.User;
import com.healthmate.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	//로그인
	@GetMapping("/auth/login")
	public String login() {
		return "system/login";
	}
	
	//로그아웃
	@GetMapping("/auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//로그인 인증 처리
	@PostMapping("/auth/login")
	public @ResponseBody String login(@RequestBody User user, HttpSession session) {
		User findUser = userService.getUser(user.getUsername()); 
		
		if(findUser.getUsername() == null) {
			return "아이디가 존재하지않아요";
		}else {
			if(findUser.getPassword().equals(findUser.getPassword())) {
				session.setAttribute("principal", findUser);
				return findUser.getUsername()+ "님 로그인 성공하셨습니다.";
			}else {
				return "비밀번호 오류";
			}
		}
	}
}
