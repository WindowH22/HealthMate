package com.healthmate.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.healthmate.domain.Post;
import com.healthmate.persistence.PostRepository;
@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		postRepository.save(post);
	}
	
	@Transactional
	public Page<Post> getPostList(Pageable pageable){
		return postRepository.findAll(pageable);
	}
	
	@Transactional
	public void deletePost(int id) {
		System.out.println("deletePostId :"+id);
		postRepository.deleteById(id);
	}
	
	@Transactional
	public void updatePost(int id, Post requestPost) {
		Optional<Post> findPost =postRepository.findById(id);
		
		if(findPost.isPresent()) {
			Post post =findPost.get();
			post.setTitle(requestPost.getTitle());
			post.setContent(requestPost.getContent());
		} else {
			System.out.println("글 찾기 실패: 아이디를 찾을 수 없습니다.");
		}
		
	}
	
}
