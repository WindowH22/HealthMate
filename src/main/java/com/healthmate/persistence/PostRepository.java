package com.healthmate.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthmate.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
