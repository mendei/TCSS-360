/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.HomeScreen;

/**
 * @author Austin
 * Test the homescreen to make sure it opens properly
 * with no failures or errors.
 */
class HomeScreenTest {



	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for {@link gui.HomeScreen#start()}.
	 */
	@Test
	void testStart() {
		try {
			HomeScreen hs = new HomeScreen();
			hs.start();
			hs.dispose();
		} catch(Exception e) {
			fail();
		}
		
		
	}



}
