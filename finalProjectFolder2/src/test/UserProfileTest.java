package test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.UserProfile;

/**
 * 
 * @author Ivan
 * 
 * JUnit tests for the UserProfile class
 *
 */

class UserProfileTest {

	UserProfile user = new UserProfile("Joe123", "password", "Joe", "Joe@email.com");
	
	
	
	
	@Test
	void testGetPassword() {
		assertEquals("password", user.getPassword());
	}

	@Test
	void testSetPassword() {
		user.setPassword("password1234");
		assertEquals("password1234", user.getPassword());
	}

	@Test
	void testGetUserName() {
		assertEquals("Joe123", user.getUserName());
	}

	@Test
	void testSetUserName() {
		user.setUserName("JoeMama");
		assertEquals("JoeMama", user.getUserName());
	}

	@Test
	void testGetName() {
		assertEquals("Joe", user.getName());
	}

	@Test
	void testSetNameString() {
		user.setName("Tom");
		assertEquals("Tom", user.getName());
	}

	@Test
	void testGetEmail() {
		assertEquals("Joe@email.com", user.getEmail());
	}

	@Test
	void testSetEmail() {
		user.setEmail("Joe@gmail.com");
		assertEquals("Joe@gmail.com", user.getEmail());
	}

	@Test
	void testToString() {
		assertEquals("Joe123,password,Joe,Joe@email.com", user.toString());
	}

}
