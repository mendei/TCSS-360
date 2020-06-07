package model;


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserProfile implements Serializable {

import javax.swing.JFrame;

public class UserProfile extends JFrame {


	private String userName;
	private String password;
	private String name;
	private String email;

	public UserProfile() {

	}


	public UserProfile(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public UserProfile(String userName, String password, String name, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
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


	public void export() {
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(new File("E:\\Profile.ser"), true);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(this);
			;
		} catch (Exception ex) {
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception e) {
				}
			}
		}
	}


}
