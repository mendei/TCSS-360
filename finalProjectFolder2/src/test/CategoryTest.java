package test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.AddCategoryGUI;
import gui.HomeScreen;
import model.Category;


/**
 * 
 * @author Ivan
 * Test that the category methods works without error.
 */
class CategoryTest {
	
     

	@Test
	void testGetCategoryName() {
		
	     Category categoryName = new Category("Garage");
		assertEquals("Garage",categoryName.getCategoryName());
	}

	@Test
	void testSetCategoryName() {
		
		Category category = new Category("Bathroom");
		category.setCategoryName("Living Room");
		assertEquals("Living Room", category.getCategoryName());
		
	}

	@Test
	void testToString() {
		
		Category category = new Category("Family Room");
		
		assertEquals("Family Room", category.toString());
		
	}

}
