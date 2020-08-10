package model;

public class UserSignInDto {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserSignInDto(String username, String password) {
		this.setEmail(username);
		this.setPassword(password);
		}
}
