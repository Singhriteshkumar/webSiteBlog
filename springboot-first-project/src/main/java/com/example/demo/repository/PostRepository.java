package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.enties.Category;
import com.example.demo.enties.Post;
import com.example.demo.enties.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
//	List<Post> findByPostTitle(String postTitle);
	
	@Query( 
	        nativeQuery = true, 
	        value = "SELECT * FROM posts  where post_title like %:keyword% ") 
			List<Post> findByPostTitle(@Param("keyword") String keyword); 
	

}
