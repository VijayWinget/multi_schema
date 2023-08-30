package com.example.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        if ("yourUsername".equals(username)) {
	            // Hardcoded password: "yourPassword"
	            String password = "$2a$10$g.4WnFj/4XTKu59p7GKDGOdP2xWm/B1ctGvD5utd7HziZT2M7yhaq"; // Password: yourPassword
	            return User.withUsername(username)
	                    .password(password)
	                    .roles("USER") // Define the user's roles/authorities here if needed
	                    .build();
	        } else {
	            throw new UsernameNotFoundException("User not found");
	        }
	    }

}
