package com.crud.serviceimp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.User;
import com.crud.repository.UserRepo;
import com.crud.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
		User saveUser = this.userRepo.save(user);
		return saveUser;
	}

	@Override
	public List<User> getAllUser() {

		List<User> allUsers = this.userRepo.findAll();
		return allUsers;
	}

	@Override
	public User getSingleUser(int userId) {

		User singleUser = this.userRepo.findById(userId).get();
		return singleUser;
	}

	@Override
	public String deleteUser(int userId) {

		User user = this.userRepo.findById(userId).get();

		if (user != null) {
			this.userRepo.deleteById(userId);
			return "User Deleted Sucessfully";
		} else {
			return "User Not Deleted Sucessfully";
		}

	}

	@Override
	public User updateUser(User user, int userId) {

		User oldUser = this.userRepo.findById(userId).get();

		oldUser.setUserEmail(user.getUserEmail());
		oldUser.setUserPhone(user.getUserPhone());

		User updatedUser = this.userRepo.save(oldUser);

		return updatedUser;
	}

}
