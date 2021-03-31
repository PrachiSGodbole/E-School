package com.schools.management.Service;


import com.schools.management.Model.User;

public interface UserService {
	 public User findUserByEmail(String email);
	 
	 public void saveUser(User user);
	 
}
