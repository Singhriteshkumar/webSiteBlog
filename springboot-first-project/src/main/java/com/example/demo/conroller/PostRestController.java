package com.example.demo.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	//create
	@PostMapping("/create/{userId}/{categoryId}/")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable long userId, @PathVariable long categoryId){
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}
	
	//getById
	@GetMapping("/get/{postId}")
	public ResponseEntity<PostDto> getPostByPostId(@PathVariable long postId ){
		PostDto byPostId = this.postService.getByPostId(postId);
		return new ResponseEntity<PostDto>(byPostId, HttpStatus.OK);
	}
	
	//update
	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDto> updateByPostId(@RequestBody PostDto postDto, @PathVariable long postId){
		PostDto updatePostById = this.postService.updatePostById(postDto, postId);
		return new ResponseEntity<PostDto>(updatePostById, HttpStatus.ACCEPTED);
	}
	
	//deleteById
	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<String> deletePostById(@PathVariable long postId){
		String deletePostById = this.postService.deletePostById(postId);
		return new ResponseEntity<String>(deletePostById, HttpStatus.ACCEPTED);
	}
	
	//getAllPost
	@GetMapping("/get/allPost")
	public ResponseEntity<List<PostDto>> getAllPost(){
		List<PostDto> allPost = this.postService.getAllPost();
		
		return ResponseEntity.ok(allPost);
	}
	
	//getPostByCategoryId
	@GetMapping("/getcategory/{categoryId}")
	public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable long categoryId){
		List<PostDto> postByCategory = this.postService.getPostByCategory(categoryId);
		return ResponseEntity.ok(postByCategory);
	}
	
	//getPostByUserId
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable long userId){
		List<PostDto> postByUser = this.postService.getPostByUser(userId);
		return ResponseEntity.ok(postByUser);
	}
	
	//getPostByTitle
	@GetMapping("/title/{title}")
	public ResponseEntity<List<PostDto>> getPostByTitle(@PathVariable String title){
		List<PostDto> searchByPostTitle = this.postService.searchByPostTitle(title);
		return ResponseEntity.ok(searchByPostTitle);
	}

}
