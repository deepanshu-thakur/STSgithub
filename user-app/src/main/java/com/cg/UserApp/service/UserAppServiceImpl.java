package com.cg.UserApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.UserApp.exception.DuplicateUserException;
import com.cg.UserApp.exception.UserNotFoundException;
import com.cg.UserApp.model.UserRegistration;
import com.cg.UserApp.repository.UserAppJpaRepo;

@Service
public class UserAppServiceImpl implements UserAppService {
	@Autowired
	private UserAppJpaRepo repo;

	//REGISTER USER
	@Override
	public boolean addUser(UserRegistration ur)throws DuplicateUserException
	{
		if(repo.existsById(ur.getUserId())) {
			throw new DuplicateUserException("User with ID - "+ur.getUserId()+" already exists");
		}
	
		repo.save(ur);
		boolean isAdded=repo.existsById(ur.getUserId());
		return isAdded;
	}
	
	//GET USER  BY ID
	@Override
	public UserRegistration getUserById(int userId) throws UserNotFoundException
	{
		
		if(!repo.existsById(userId))
		{
			throw new UserNotFoundException("User with Id : -"+userId+ " Not Found");
		}
		return repo.findById(userId).get();
	}
	
	//UPDATE USER
	@Override
	public UserRegistration updateUser(UserRegistration ur) throws UserNotFoundException
	{
		if(!repo.existsById(ur.getUserId()))
		{
			throw new UserNotFoundException("User with Id : -"+ur.getUserId()+ " Not Found");
		}
		
		return repo.save(ur);
	}
	
	//DELETE USER
	@Override
	public boolean deleteUser(int userId) throws UserNotFoundException
	{
		if(!repo.existsById(userId))
		{
			throw new UserNotFoundException("User with Id : -"+userId+ " Not Found");
		}
		repo.deleteById(userId);
		return !repo.existsById(userId);
	}
	
	//GET ALL USERS
	@Override
	public List<UserRegistration> getAllUsers()
	{
		return repo.findAll();
	}

	//LOGIN USER
	@Override
	public boolean LoginUser(int userId) throws UserNotFoundException {
		if(!repo.existsById(userId))
		{
			throw new UserNotFoundException("User with Id : -"+userId+ " Not Found");
		}
		// TODO Auto-generated method stub
		return repo.existsById(userId);

	}
	

}
