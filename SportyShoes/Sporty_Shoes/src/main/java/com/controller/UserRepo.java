package com.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer>{
	@Query("select user from User user where user.name=?1")
	public User findByName(String name);
	@Query("select user from User user where user.password=?1")
	public User findByPassword(String password);
	
	@Query("select user from User user")
	public List<User> findAllUsers();

}
