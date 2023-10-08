package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.MethodInvocationRecorder.Recorded.ToMapConverter;
import org.springframework.stereotype.Service;

import com.example.demo.enties.User;
import com.example.demo.exeception.ResourceNotFoundExecption;
import com.example.demo.payload.UserDto;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User users = new User();
		
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		users.setAbout(userDto.getAbout());
		userRepo.save(users);
		return "User is sussesfully saved";
	}

	@Override
	public String updateUser(UserDto userDto, long userId) {
		// TODO Auto-generated method stub
		User users=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExecption("user","Id",userId));
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setAbout(userDto.getAbout());
		users.setPassword(userDto.getPassword());
		users.setCity(userDto.getCity());
		users.setRole(userDto.getRole());
		
		User save = userRepo.save(users);
		return "Update Sucess fully";
	}

	@Override
	public UserDto getUserById(long userId) {
		// TODO Auto-generated method stub
		User findById = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundExecption("user", "Id", userId));
		UserDto userToUserDto = userToUserDto(findById);
		return userToUserDto;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> users = userRepo.findAll();
		List<User> userlist = users.stream().map(user->user).collect(Collectors.toList());
		//userToUserDto(userList);
		return userlist;
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		User orElseThrow = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExecption("user", "Id", userId));
		userRepo.delete(orElseThrow); userRepo.deleteById(userId);
		 
	}
	
	private User UserDtotoUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
	
	private UserDto userToUserDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
