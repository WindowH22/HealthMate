package com.healthmate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthmate.domain.Post;
import com.healthmate.domain.User;
import com.healthmate.persistence.PostRepository;
import com.healthmate.security.jpa.UserDetailsImpl;
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
	
	// 글 등록 하기
		@PostMapping("/post/insertPost")
		@ResponseBody
		public String insertPost(@RequestBody Post post,
				@AuthenticationPrincipal UserDetailsImpl userDetails) {
			// Post 객체를 등록하기 위해서는 반드시 User 객체를 Post에 설정해야 한다.
			// 그래야 Post가 POST 테이블에 등록될 때 FK(USER_ID) 컬럼에 회원의 PK(ID)를 등록해준다.
			User user = userDetails.getUser();
			post.setUser(user);
			postService.insertPost(post);
			return "새로운 1:1문의 를 등록했습니다.";
		}


	// 글 상세보기
	@GetMapping("post/get/{id}")
	public String getPost(@PathVariable int id, Model model) {

		Optional<Post> post = postRepository.findById(id);

		if (post.isPresent()) {
			model.addAttribute("post", post.get());
			System.out.println("아이디: "+post.get().getUser().getUsername());
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
	
	// 글 수정 페이지 이동
	@GetMapping("post/updatePost/{id}")
	public String updatePost(@PathVariable int id,Model model) {
		Optional<Post> post = postRepository.findById(id);
		
		if(post.isPresent()) {
			model.addAttribute("post",post.get());
			return "post/updatePost";
		}
		return "";
		
	}
	
	// 글 수정하기
	@PutMapping("post/updatePost/{id}")
	@ResponseBody
	public String updatePost(@PathVariable int id ,@RequestBody Post post) {
		postService.updatePost(id,post);
		return "수정이 완료되었습니다.";
	}
	
	
}
