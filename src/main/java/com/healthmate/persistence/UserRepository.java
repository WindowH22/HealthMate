package com.healthmate.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmate.domain.User;

//entity가 붙어있는 타입 , 클래스 
@Repository // DAO와 같은기능
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// SELECT * FROM user WHERE username = ?1;
	Optional<User> findByUsername(String username); //findUserByUsername과 같다.

}

