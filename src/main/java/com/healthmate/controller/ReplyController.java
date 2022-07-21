package com.healthmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthmate.domain.Reply;
import com.healthmate.security.jpa.UserDetailsImpl;
import com.healthmate.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	ReplyService replyService;


	
	// 댓글 동록 하기
	@PostMapping("/post/{postId}/insertReply")
	@ResponseBody
	public String insertPost(@PathVariable int postId,@RequestBody Reply reply,
			@AuthenticationPrincipal UserDetailsImpl userDetails) {
		
		replyService.insertReply(userDetails.getUser(), postId, reply);

		return "댓글을 등록했습니다.";
	}

		
}
