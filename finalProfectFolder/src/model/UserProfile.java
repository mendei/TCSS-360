package model;

import javax.swing.JFrame;

public class UserProfile extends JFrame {

	private String name1;

	private String email;

	public UserProfile() {

	}

	public void setName(String theName) {
		name1 = theName;
	}

	public void setEmail(String theEmail) {
		email = theEmail;
	}

	public String getName() {
		return name1;
	}

	public String getEmail() {
		return email;
	}

}
