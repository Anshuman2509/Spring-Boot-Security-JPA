package com.example.audi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.audi.model.User;
import com.example.audi.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByName(username);
		if(user==null) {
			throw new UsernameNotFoundException("user Not found");
		}
		else {
			MyUserDetails myUserDetails=new MyUserDetails();
			myUserDetails.setUser(user);
			return myUserDetails;
		}
		
	}

}
