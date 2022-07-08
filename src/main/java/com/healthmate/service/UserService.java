package com.healthmate.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthmate.domain.User;
import com.healthmate.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		user.setRole("USER");
		userRepository.save(user);
	}
	
	@Transactional
	public User getUser(String username) {
		Optional<User> findUser = userRepository.findByUsername(username);
		if(findUser.isPresent()) {
			return findUser.get();
		}
		return new User();
	}
	
	
	
}
