package com.crud.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.entity.User;
import com.crud.message.SuccessMessage;
import com.crud.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/crud")
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@PostMapping("/createuser")
	public ResponseEntity<SuccessMessage> createUser(@Valid @RequestBody User user){
		
		User createUser = this.userService.createUser(user);
		
		if (createUser!=null) {
			
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("User Created Sucessfully", true),HttpStatus.CREATED);
		}else {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("Something went wrong", false),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getalluser")
	public ResponseEntity<?> getAllUser(){
		
		List<User> allUser = this.userService.getAllUser();
		
		if (allUser.isEmpty()) {
			return new ResponseEntity<>("User Not Exit.",HttpStatus.OK);
			
		} else {
			return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
		}
	}
	
	
	@GetMapping("getsingleuser/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable int userId){
		
		User singleUser = this.userService.getSingleUser(userId);
		
		return new ResponseEntity<User>(singleUser,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<SuccessMessage> deleteUser(@PathVariable int userId){
		
		String deleteUser = this.userService.deleteUser(userId);
		
		if (deleteUser!=null) {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage(deleteUser, true),HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("Something went wrong", false),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<SuccessMessage> userUpdated(@RequestBody User user,@PathVariable int userId){
		
		User updateUser = this.userService.updateUser(user, userId);
		
		if (updateUser != null) {
			
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("User Updated Sucessfully", true),HttpStatus.OK);
		} else {
			return new ResponseEntity<SuccessMessage>(new SuccessMessage("User Not Updated Sucessfully", false),HttpStatus.BAD_REQUEST);
		}
	}
}
