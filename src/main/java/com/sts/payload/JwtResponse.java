package com.sts.payload;

public class JwtResponse {
	
	private String jwtToken;
	private String username;
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtResponse(String jwtToken, String username) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
