package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.Test;

import controller.FileManagementController;
import model.UserProfile;

/**
 * JUnit Test for FileManagementController
 * 
 * @author Anh Tran
 */
public class FileManagementControllerTest {

	FileManagementController fileController = new FileManagementController();

	@Test
	public void verifyAuthenticationTest1() {
		String userName = "admin";
		String password = "123";
		assertTrue(fileController.verifyAuthentication(userName, password));
	}

	@Test
	public void verifyAuthenticationTest2() {
		String userName = "admin";
		String password = "aaa";
		assertFalse(fileController.verifyAuthentication(userName, password));
	}

	@Test
	public void getUserBasedOnUserNameTest1() {
		String userName = "admin";
		assertEquals(userName, fileController.getUserBasedOnUserName(userName).getUserName());
	}

	@Test
	public void getUserBasedOnUserNameTest2() {
		String userName = "Not_Exist";
		assertEquals(null, fileController.getUserBasedOnUserName(userName));
	}

	@Test
	public void importSettingTest() {
		try {
			UserProfile user = new UserProfile();
			user.setUserName("admin");
			user.setPassword("123");
			user.setName("Admin");
			user.setEmail("Admin@gmail.com");
			fileController.importSetting(user);
			assertTrue(true);
		}
		catch(Exception e) {
			fail();
		}
	}

	@Test
	public void getListOfFileByFolderTest() {
		assertNotNull(fileController.getListOfFileByFolder("FileFolder"));
	}
	
	@Test
	public void addCategoryTest() {
		fileController.addCategory("Demo");
		File f = new File("FileFolder\\Demo");
		f.delete();
		assertTrue(true);
	}
	
	@Test
	public void getCategoriesTest() {
		assertNotNull(fileController.getCategories());
	}
	
}
