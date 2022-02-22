package com.cg.UserApp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.UserApp.model.UserRegistration;
import com.cg.UserApp.repository.UserAppJpaRepo;

@SpringBootTest
class UserAppServiceImplTest {


	@Autowired
	private UserAppServiceImpl service;
	
	@Mock
	private UserAppJpaRepo repo;

	UserRegistration ur=new UserRegistration(102,"hemanth","h99**","hemanth@gmail.com");
	@Test
	void testAddUser() {
		when(repo.existsById(ur.getUserId())).thenReturn(true);
		assertTrue(service.addUser(ur));
		
	}
	@Test
	void testLoginUser() {
		when(repo.existsById(ur.getUserId())).thenReturn(true);
		assertTrue(service.LoginUser(ur.getUserId()));
	}


	@Test
	void testGetUserById() {
		
		when(repo.getById(102)).thenReturn(ur);
		int userId=102;
		UserRegistration user=repo.getById(userId);
		assertEquals(user,ur);
		
	}
	

	@Test
	void testUpdateUser() {
		
		when(repo.save(ur)).thenReturn(ur);
		assertEquals(ur,service.updateUser(ur));
	}

	
	
	@Test
	void testDeleteUser() {
		
		int userId=102;
		assertTrue(service.deleteUser(userId));
		
		
	}

	

	
}