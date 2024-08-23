package com.sts.controller;

import javax.management.RuntimeErrorException;
import javax.naming.AuthenticationException;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.config.JwtHelper;
import com.sts.payload.JwtRequest;
import com.sts.payload.JwtResponse;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;
    
    private Logger logger = (Logger) LoggerFactory.getLogger(AuthController.class);
    
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest authRequest) throws AuthenticationException {
        logger.info(authRequest.getUsername());
        logger.info(authRequest.getPassword());
    	this.doAuthenticate(authRequest.getUsername(),authRequest.getPassword());
    	
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        System.out.println("llllllllllllll");
    	String token = this.jwtHelper.generateToken(authRequest.getUsername());
    	JwtResponse res = new JwtResponse();
    	res.setUsername(authRequest.getUsername());
    	res.setJwtToken(token);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }

	private void doAuthenticate(String username, String password) {
		System.out.println("kkkkkkkkkkkkk");
		
		UsernamePasswordAuthenticationToken authen = new UsernamePasswordAuthenticationToken(username , password);
		try {
			this.manager.authenticate(authen);
		} catch (BadCredentialsException e) {
			throw new RuntimeException("Invalid username and password");
		}
		
	}

}
