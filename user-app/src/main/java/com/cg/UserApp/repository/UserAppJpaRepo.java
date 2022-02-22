package com.cg.UserApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.UserApp.model.UserRegistration;

public interface UserAppJpaRepo extends JpaRepository<UserRegistration,Integer>{
	
	

}
