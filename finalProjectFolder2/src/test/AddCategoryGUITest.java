package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gui.AddCategoryGUI;
import gui.HomeScreen;

/**
 * 
 * @author Ivan
 * Test that the add category window opens up properly 
 * without errors.
 */
public class AddCategoryGUITest {

	HomeScreen hs = new HomeScreen();

	@Test
	public void testAddCategoryGUI() {
		try {
			
			AddCategoryGUI gui = new AddCategoryGUI(hs);
			gui.dispose();
			
				
		} catch (Exception e) {
			fail();
			
		}
	}

}
