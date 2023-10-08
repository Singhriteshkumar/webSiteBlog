package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.payload.CategoryDto;

@Service
public interface CategoryService {
	
	/* create category*/
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	/* update category */
	public CategoryDto updateCategory(CategoryDto categoryDto, long categoryId);
	
	/* delete category */
	public String deleteCategory(long categoryId);
	
	/* get category */
	public CategoryDto getCategory(long categoryId);
	
	/* get All category */
	public List<CategoryDto> getAllCategory();

}
