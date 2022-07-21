package com.healthmate.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthmate.domain.Post;
import com.healthmate.domain.Reply;
import com.healthmate.domain.User;
import com.healthmate.persistence.PostRepository;
import com.healthmate.persistence.ReplyRepository;
@Service
public class ReplyService {

	@Autowired
	ReplyRepository replyRepository;
	
	@Autowired
	PostRepository postRepository;
	
	// 댓글 등록
	@Transactional
	public void insertReply(User user,int postId, Reply requestReply) {
		
		Post post = postRepository.findById(postId).orElseThrow(()->{
			return new IllegalArgumentException("댓글쓰기 실패: 게시글 id를 찰을 수 없습니다.");
		});
		
		requestReply.setUser(user);
		requestReply.setPost(post);
		
		replyRepository.save(requestReply);;
		
	}
	
	// 댓글 삭제
	
	
}
