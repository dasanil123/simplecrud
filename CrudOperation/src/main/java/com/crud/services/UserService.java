package com.crud.services;

import java.util.List;

import com.crud.entity.User;

public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getAllUser();
	
	public User getSingleUser(int userId);
	
	public String deleteUser(int userId);
	
	public User updateUser(User user,int userId);
}
