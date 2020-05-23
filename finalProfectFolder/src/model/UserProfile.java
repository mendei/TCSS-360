package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class UserProfile extends JFrame{
	
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
