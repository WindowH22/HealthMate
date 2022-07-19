package com.healthmate.service;

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
	
	
}
