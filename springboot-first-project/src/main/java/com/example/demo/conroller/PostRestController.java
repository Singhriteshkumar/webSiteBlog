package com.example.demo.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.PostDto;
import com.example.demo.service.PostService;

@RestController
@RequestMapping("/api/post/")
public class PostRestController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("user/{userID}/category/{category}/create")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable long userId, @PathVariable long categoryId){
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED);
	}

}
