package com.sts.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder ecncode;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Load the user from your database or another source
        // This example returns a hardcoded user
        return new User("admin", this.ecncode.encode("abc") , new ArrayList<>());
		
	}

}
