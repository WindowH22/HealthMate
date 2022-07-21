package com.healthmate.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthmate.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
}
