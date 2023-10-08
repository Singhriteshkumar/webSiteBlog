package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.enties.User;
import com.example.demo.payload.UserDto;

@Service
public interface UserService {
	
	public String createUser(UserDto userDto);
	
	public String updateUser(UserDto userDto, long userId);
	
	public UserDto getUserById(long userId);
	
	public List<User> getAllUser();
	
	public void deleteUser(long userId);

}
