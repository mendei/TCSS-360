package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gui.AddCategoryGUI;
import gui.HomeScreen;
import model.UserProfile;

/**
 * 
 * @author Ivan Test that the add category window opens up properly without
 *         errors.
 */
public class AddCategoryGUITest {

	@Test
	public void testAddCategoryGUI() {
		try {
			UserProfile user = new UserProfile("admin", "", "", "");
			HomeScreen hs = new HomeScreen(user);
			AddCategoryGUI gui = new AddCategoryGUI(hs);
			gui.dispose();

		} catch (Exception e) {
			fail();

		}
	}

}
