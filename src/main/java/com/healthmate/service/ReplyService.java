package com.healthmate.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.healthmate.domain.Post;
import com.healthmate.persistence.PostRepository;
import com.healthmate.persistence.ReplyRepository;
@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	// 댓글 등록
	@Transactional
	public String insertReply() {
		
		
		return "댓글이 등록되었습니다.";
	}
	
	// 댓글 삭제
	
	
}
