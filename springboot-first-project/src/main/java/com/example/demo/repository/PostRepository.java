package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.enties.Category;
import com.example.demo.enties.Post;
import com.example.demo.enties.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<User> findByUser(User user);
	
	List<Category> findByCategory(Category category);
	
//	List<Post> findByKe

}
