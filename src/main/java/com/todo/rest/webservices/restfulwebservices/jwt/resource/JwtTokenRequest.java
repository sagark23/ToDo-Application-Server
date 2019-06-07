package com.todo.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

//	{
//		"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU2MDQ5NTY1MywiaWF0IjoxNTU5ODkwODUzfQ.pcmbCL51AtlMQ5PDg4ZkwL2XMhW9nF4bR5MPSuAtvdGuxUieqWylTNQQ0K12amrGiUzYyiIFgyLxDUV_DJN-_w"
//	}
//
	private String username;
	private String password;

	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
