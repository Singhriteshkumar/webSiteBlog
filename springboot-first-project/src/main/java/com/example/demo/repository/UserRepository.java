package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.enties.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
