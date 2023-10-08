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
	Post getByPost(long postId);
	
	//getAll
	List<Post> getAllPost();
	
	//getByCategory
	List<Post> getPostByCategory(long categoryId);
	
	//getByUser
	List<Post> getPostByUser(long userId);
	
	//getByPost
	List<Post> searchByPost(String keyword);
	

}
