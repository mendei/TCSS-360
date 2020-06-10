package test;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import gui.AddFileGUI;
import gui.HomeScreen;

public class AddFileGUITest {

	/**
	 * @author Ivan Mendez
	 * 
	 * Test to start up addFIleGUI without errors.
	 */

	@Test
	public void testStart() {
		
		HomeScreen hs = new HomeScreen();

		try {
			
			AddFileGUI gui = new AddFileGUI(hs);
			gui.start();
			gui.dispose();
			
		} catch (Exception e) {
			fail();
		}
		
	}

}
