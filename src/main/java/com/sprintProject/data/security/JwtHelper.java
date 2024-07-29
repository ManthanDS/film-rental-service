package com.sprintProject.data.security;

public class JwtHelper {

	public class JwtRequest {

		 

	    private String loginId;

	    private String password;

	 

	    public JwtRequest() {

	        // Default constructor

	    }

	    

	    

	 

	    

	    public JwtRequest(String loginId, String password) {

	        this.loginId = loginId;

	        this.password = password;

	    }

	 

	    public String getLoginId() {

	        return loginId;

	    }

	 

	    public void setLoginId(String loginId) {

	        this.loginId = loginId;

	    }

	 

	    public String getPassword() {

	        return password;

	    }

	 

	    public void setPassword(String password) {

	        this.password = password;

	    }

	 

		@Override

		public String toString() {

			return "JwtRequest [loginId=" + loginId + ", password=" + password + "]";

		}

	    

	}

	 


}
