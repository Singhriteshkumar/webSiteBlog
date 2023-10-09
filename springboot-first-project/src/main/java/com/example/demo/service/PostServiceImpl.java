package com.example.demo.service;


 import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
		Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundExecption("Post", "Post Id", postId));
		post.setPostTitle(postDto.getPostTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		post.setAddedDate(new Date());
		
		Post updatePost = this.postRepository.save(post);
		return this.modelMapper.map(updatePost, PostDto.class);
	}

	@Override
	public String deletePostById(long postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundExecption("Post", "Post id", postId));
		if(!post.equals(null)) {
			this.postRepository.delete(post);
			return "Post Delete Success fully";
		}
		return null;
	}

	@Override
	public PostDto getByPostId(long postId) {
		// TODO Auto-generated method stub
		Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundExecption("Post", "Post id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		List<Post> findAll = this.postRepository.findAll();
		List<PostDto> postDto = findAll.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> getPostByCategory(long categoryId) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundExecption("category", "category id", categoryId));
		List<Category> findByCategory = this.postRepository.findByCategory(category);
		List<PostDto> collect = findByCategory.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> getPostByUser(long userId) {
		// TODO Auto-generated method stub
		User userCategory = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundExecption("User", "user Id", userId));
		List<User> findByUser = this.postRepository.findByUser(userCategory);
		List<PostDto> postDto = findByUser.stream().map(post->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> searchByPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


}
