package com.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "username")
	@NotBlank(message = "User name can't be empty")
	private String userName;
	
	@Column(unique = true,name = "useremail")
	@NotBlank(message = "User email can't be empty")
	@Email(message ="Please provied valid mail id" )
	private String userEmail;
	
	@Column(name = "userphone")
	@Size(min = 10,max = 12,message = "Phone number  should be range between 10-12")
	private String userPhone;

}
