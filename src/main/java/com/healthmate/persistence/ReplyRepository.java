package com.healthmate.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthmate.domain.Post;

public interface ReplyRepository extends JpaRepository<Post, Integer>{
}
