package com.project.school.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.school.entities.User;
import com.project.school.exceptions.ResourceNotFoundException;
import com.project.school.repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// loading user from database by username
		System.out.println("user" + username);
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User ", " email : " + username, 0));
		System.out.println(user);
		return user;
	}

}
