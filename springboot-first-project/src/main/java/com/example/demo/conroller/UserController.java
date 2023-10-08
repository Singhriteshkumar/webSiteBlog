package com.example.demo.conroller;


import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

import com.example.demo.enties.User;
import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.UserDto;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/* Create user */
	@PostMapping("/")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto){
		
		String createUser = userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}
	
	/* Update User by name */
	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable long userId) {
		String updateUser = userService.updateUser(userDto, userId);
		return new ResponseEntity<String>(updateUser, HttpStatus.CREATED);
	}
	
	/* get user by ID */
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@Valid @PathVariable Integer userId){
		UserDto userById = userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userById, HttpStatus.CREATED);
	}
	
	/* delete User by id */
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUserById(@Valid @PathVariable long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted success fully", true), HttpStatus.OK);
	}
	
	/* get all user */
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

}
