package com.example.demo.payload;

import java.util.Date;

import com.example.demo.enties.Category;
import com.example.demo.enties.User;


public class PostDto {
	
	private long postId;
	
	private String postTitle;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto categoryDto;
	
	private UserDto userDto;

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public CategoryDto getCategory() {
		return categoryDto;
	}

	public void setCategory(CategoryDto category) {
		this.categoryDto = category;
	}

	public UserDto getUser() {
		return userDto;
	}

	public void setUser(UserDto user) {
		this.userDto = user;
	}

}
