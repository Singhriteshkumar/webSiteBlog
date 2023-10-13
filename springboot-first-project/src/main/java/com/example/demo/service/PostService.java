package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.enties.Post;
import com.example.demo.payload.PostDto;

@Service
public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto, long userId, long categotyId);
	
	//updateByPostId
	PostDto updatePostById(PostDto postDto, long postId);
	
	//deleteByPostId
	String deletePostById(long postId);
	
	//getPostById
	PostDto getByPostId(long postId);
	
	//getPostAll
	List<PostDto> getAllPost();
	
	//getPostByCategory
	List<PostDto> getPostByCategory(long categoryId);
	
	//getPostByUser
	List<PostDto> getPostByUser(long userId);
	
	//getPostByTitle
	List<PostDto> searchByPostTitle(String keyword);
	

}
