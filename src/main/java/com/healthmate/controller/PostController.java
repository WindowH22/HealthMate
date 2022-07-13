package com.healthmate.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthmate.domain.Post;
import com.healthmate.domain.User;
import com.healthmate.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	@GetMapping( {"","/"})
	public String getPostList(Model model,
			@PageableDefault(size=3,sort= "id", direction = Direction.DESC) Pageable pageable) 
	{
		model.addAttribute("postList", postService.getPostList(pageable));
		return "welcome";
	}
	
	@GetMapping("post/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}
	
	@PostMapping("post/insertPost")
	@ResponseBody
	public String insertPost(@RequestBody Post post,HttpSession session ) {
		
		User Principal = (User) session.getAttribute("principal");
		post.setUser(Principal);
		postService.insertPost(post);
		return "post/insertPost";
	}
}


