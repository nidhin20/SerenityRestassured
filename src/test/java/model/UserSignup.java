package model;

import java.util.Date;

public class UserSignup {

	private String name;

	private String email;
	
	private String phoneno;
	
	private Date dob;
	
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserSignup(String name, String email, String phoneno, Date dob, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.dob = dob;
		this.password = password;
	}
	
}
