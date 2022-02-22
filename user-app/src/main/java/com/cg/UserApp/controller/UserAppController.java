package com.cg.UserApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.UserApp.exception.DuplicateUserException;
import com.cg.UserApp.model.UserRegistration;
import com.cg.UserApp.service.UserAppService;


@RestController
public class UserAppController {

	@Autowired
	private UserAppService service;
	
	
	//REGISTRATION FOR USERS
	@PostMapping(value="/users/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public boolean addUser(@RequestBody UserRegistration ur) {
		
	boolean isAdded =service.addUser(ur);
	if(isAdded)
	{
		System.out.println("REGISTRATION SUCCESSFUL FOR USER :"+ur);		
	}
	else 
		System.out.println("Resgistraion unsuccessful");
	return isAdded;
	}
		

	// GET ALL USERS INFO
	
	@GetMapping(value = "/users")
	public List<UserRegistration> getAllUsers(){
	return service.getAllUsers();
	}
	
		//CHECK USER WITH ID
	@GetMapping("/users/id/{id}")
	public UserRegistration getUserById(@PathVariable("id") int userId) {
	return service.getUserById(userId);
	}
	
	// LOGIN USER
	@GetMapping("/users/login/id/{id}/password/{password}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)

	public boolean getUserByIdPswd(@PathVariable("id") int userId)
	{
		boolean isloggedin=service.LoginUser(userId);
		if(isloggedin)
		{
			System.out.println("LOGIN SUCCESSFUL WITH USER ID: "+userId);
		}
		else System.out.println("LOGIN UNSUCCESSFUL WITH USER ID : "+userId);
		return isloggedin;
		
	}
	
	//DELETE USER
	@DeleteMapping("/users/delete/id/{id}")
	public ResponseEntity<Boolean> deleteUserByCode(@PathVariable("id") int userId)
	{
	
	boolean isDeleted =  service.deleteUser(userId);
	
	return new ResponseEntity<>(isDeleted,HttpStatus.OK);
	
	}
	//UPDATE USER
	
	@PutMapping("/users/update")
	public ResponseEntity<UserRegistration> updateUser(@RequestBody UserRegistration ur) {
	UserRegistration updatedItem = service.updateUser(ur);
	return ResponseEntity.ok(updatedItem);
	}
	
	
	
}
