package com.example.demo.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.PostDto;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostRestController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/create/{userId}/{categoryId}/")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable long userId, @PathVariable long categoryId){
		long categoryid=Long.valueOf(categoryId);
		long userid=Long.valueOf(userId);
		System.out.println("------------------------------------------------------------");
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{postId}")
	public ResponseEntity<PostDto> getPostByPostId(@PathVariable long postId ){
		PostDto byPostId = this.postService.getByPostId(postId);
		return new ResponseEntity<PostDto>(byPostId, HttpStatus.OK);
	}
	
	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDto> updateByPostId(@RequestBody PostDto postDto, @PathVariable long postId){
		PostDto updatePostById = this.postService.updatePostById(postDto, postId);
		return new ResponseEntity<PostDto>(updatePostById, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/allPost")
	public ResponseEntity<List<PostDto>> getAllPost(){
		List<PostDto> allPost = this.postService.getAllPost();
		
		return ResponseEntity.ok(allPost);
	}

}
