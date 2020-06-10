package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Category;
import model.File;

class FileTest {

	Category category = new Category("Living Room");
		File file = new File("C:/home", "TV", category);

	@Test
	void testGetFileName() {
		
		assertEquals("TV", file.getFileName());
		
	}

	@Test
	void testSetFileName() {
		
		file.setFileName("Oven");
		assertEquals("Oven", file.getFileName());
	}

	@Test
	void testGetPath() {
		assertEquals("C:/home", file.getPath());
	}

	@Test
	void testSetPath() {
		file.setPath("C:/office");
		assertEquals("C:/office", file.getPath());
	}

	@Test
	void testGetCategory() {
		assertEquals(category, file.getCategory());
	}

	@Test
	void testSetCategory() {
		Category category1 = new Category("Bedroom");
		file.setCategory(category1);
		
		assertEquals(category1, file.getCategory());
	}

}
