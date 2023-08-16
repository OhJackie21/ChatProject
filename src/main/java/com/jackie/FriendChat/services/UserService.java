package com.jackie.FriendChat.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jackie.FriendChat.models.User;
import com.jackie.FriendChat.models.validators.UserLogin;
import com.jackie.FriendChat.models.validators.UserUpdate;
import com.jackie.FriendChat.repositories.UserRepository;
import com.jackie.FriendChat.repositories.UserUpdateRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserUpdateRepository useUpRepo;

//Register User .........................
	public User register(
			User newUser,
			BindingResult result) {
		// Find user in the DB by email
		Optional<User> potentUser = userRepo.findByEmail(newUser.getEmail());
		
		// Reject if email is taken (present in database)
		if(potentUser.isPresent()) {
			result.rejectValue("email", "Matches", "This email is already taken!");
		}
		
		// Reject if password doesn't match confirmation
		if(!newUser.getPassword().equals(newUser.getConfirmpass())) {
			result.rejectValue("confirmpass", "Matches", "The Confirm Password must match Password!");
    	}
		
		// Return null if result has errors
		if(result.hasErrors()) {
			return null;
		}
		// Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
        return userRepo.save(newUser);
	}

//Log In User.......................................
	public User login(
			UserLogin newLogin,
			BindingResult result) {
		// Find user in the DB by email
		Optional<User> potentUser = userRepo.findByEmail(newLogin.getEmail());
			
		// Reject if email is NOT present
		if(!potentUser.isPresent()) {
			result.rejectValue("email", "Matches", "This email does not exist!");
			return null;
		}
		
		User user = potentUser.get();
		
		// Reject if BCrypt password match fails
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
    	
    	 // Return null if result has errors
    	if(result.hasErrors()) {
        	return null;
        }
    	
    	// Otherwise, return the user object
        return user;
		
	}

//Find One user by Id...............................
	public User findbyID(Long userId) {
		// Find user in the DB by id
		Optional<User> potentialUser = userRepo.findById(userId);
		
		//Return what potentialUser has
		if(potentialUser.isPresent()) {
			return potentialUser.get();
		}
		
		//Otherwise, return null
		return null;
	}
	
//Update User information..................................
	public UserUpdate update(UserUpdate user) {
		
		return useUpRepo.save(user);
	}
}
