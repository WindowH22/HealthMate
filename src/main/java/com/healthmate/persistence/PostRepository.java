package com.healthmate.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthmate.domain.Post;
import com.healthmate.domain.User;

public interface PostRepository extends JpaRepository<Post, Integer>{

	
	// SELECT * FROM user WHERE username = ?1;
		Optional<Post> findByTitle(String title); //findPostByTitle과 같다.
}
