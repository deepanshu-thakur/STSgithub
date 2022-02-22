package com.cg.UserApp.service;
import java.util.List;

//import com.cg.UserApp.exception.DuplicateUserException;
import com.cg.UserApp.model.UserRegistration;

public interface UserAppService {
	
	public boolean addUser(UserRegistration ur);
	public UserRegistration getUserById(int userId);
	public UserRegistration updateUser(UserRegistration ur);
	public boolean deleteUser(int userId);
	public List<UserRegistration> getAllUsers();
	public boolean LoginUser(int userId);
		
}


