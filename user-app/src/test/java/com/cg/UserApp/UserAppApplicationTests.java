package com.cg.UserApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.UserApp.service.UserAppService;

@SpringBootTest
class UserAppApplicationTests {
	
	@Autowired
	UserAppService service;

	@Test
	void contextLoads() {
	}
	
	

	}


