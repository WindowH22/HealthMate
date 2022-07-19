package com.healthmate.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthmate.domain.Post;
import com.healthmate.domain.User;
import com.healthmate.persistence.PostRepository;
import com.healthmate.service.PostService;

@Controller
public class PostController {
	@Autowired
	private PostService postService;

	@Autowired
	private PostRepository postRepository;

	@GetMapping({ "", "/" })
	public String getPostList(Model model,
			@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("postList", postService.getPostList(pageable));
		return "welcome";
	}
	
	// 글등록 화면 이동
	@GetMapping("post/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}
	
	// 글동록 하기
	@PostMapping("post/insertPost")
	@ResponseBody
	public String insertPost(@RequestBody Post post, HttpSession session) {

		User Principal = (User) session.getAttribute("principal");
		post.setUser(Principal);
		postService.insertPost(post);
		return "post/insertPost";
	}

	// 글 상세보기
	@GetMapping("post/get/{id}")
	public String getPost(@PathVariable int id, Model model) {

		Optional<Post> post = postRepository.findById(id);

		if (post.isPresent()) {
			model.addAttribute("post", post.get());
			return "post/getPost";
		} else {
			return "welcome";
		}
	}
	
	// 글 삭제하기
	
	@DeleteMapping("post/deletePost/{id}")
	@ResponseBody
	public String deletePost(@PathVariable int id) {
		postService.deletePost(id);
		return "글이 삭제되었습니다.";
	}
	
}
