package com.example.demo.service;


 import java.util.List;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enties.Category;
import com.example.demo.enties.Post;
import com.example.demo.enties.User;
import com.example.demo.exeception.ResourceNotFoundExecption;
import com.example.demo.payload.PostDto;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired	
	PostRepository postRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	CategoryRepo categoryRepository;

	@Override
	public PostDto createPost(PostDto postDto, long userId, long categoryId) {
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundExecption("User", "user id", userId));
		
		Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundExecption("Category", "category id", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("dafult.png");
		post.setAddedDate(new Date());
		post.setCategory(category);
		post.setUser(user);
		
		Post savePost = this.postRepository.save(post);
		return this.modelMapper.map(savePost, PostDto.class);
	}

	@Override
	public PostDto updatePostById(PostDto postDto, long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePostById(long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getByPost(long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByCategory(long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchByPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


}
