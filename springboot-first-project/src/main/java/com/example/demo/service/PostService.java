package com.example.demo.service;

import java.util.List;

import com.example.demo.enties.Post;
import com.example.demo.payload.PostDto;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto, long userId, long categotyId);
	
	//update
	PostDto updatePostById(PostDto postDto, long postId);
	
	//delete
	String deletePostById(long postId);
	
	//getById
	PostDto getByPostId(long postId);
	
	//getAll
	List<PostDto> getAllPost();
	
	//getByCategory
	List<PostDto> getPostByCategory(long categoryId);
	
	//getByUser
	List<PostDto> getPostByUser(long userId);
	
	//getByPost
	List<PostDto> searchByPost(String keyword);
	

}
