package model;

import javax.swing.JFrame;

public class UserProfile extends JFrame {

	private String userName;
	private String password;
	private String name;
	private String email;

	public UserProfile() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public String toString() {
		return String.format("%s,%s,%s,%s", userName, password, name, email);
	}

}
