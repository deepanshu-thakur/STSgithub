package com.cg.UserApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRegistration {
	@Id
	private int userId;
	private String userName;
	private String password;
	private String emailId;
	

}
