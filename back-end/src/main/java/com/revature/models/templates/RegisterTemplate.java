package com.revature.models.templates;

import java.util.Objects;

public class RegisterTemplate {
	private String fName;
	private String lName;
	private String username;
	private String password;
	private String vPassword;
	private String email;
	
	public RegisterTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegisterTemplate(String fName, String lName, String username, String password, String vPassword,
			String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.vPassword = vPassword;
		this.email = email;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getvPassword() {
		return vPassword;
	}
	
	public void setvPassword(String vPassword) {
		this.vPassword = vPassword;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, fName, lName, password, username, vPassword);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterTemplate other = (RegisterTemplate) obj;
		return Objects.equals(email, other.email) && Objects.equals(fName, other.fName)
				&& Objects.equals(lName, other.lName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username) && Objects.equals(vPassword, other.vPassword);
	}
	
	@Override
	public String toString() {
		return "RegisterTemplate [fName=" + fName + ", lName=" + lName + ", username=" + username + ", password="
				+ password + ", vPassword=" + vPassword + ", email=" + email + "]";
	}
}
