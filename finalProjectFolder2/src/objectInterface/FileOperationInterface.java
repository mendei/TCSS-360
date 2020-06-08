package objectInterface;

import java.io.File;
import java.util.List;

import model.Category;
import model.UserProfile;

/***
 * This interface will provide the methods to manipulate such as add, delete,
 * modify or access to the file system Any method is implemented by
 * FileManagementController must be declared here.
 * 
 * @author Anh Tran
 */
public interface FileOperationInterface {

	public void importSetting(UserProfile userProfile);

	public UserProfile getUserBasedOnUserName(String userName);

	public File[] getListOfFileByFolder(String path);

	public void addFile(model.File file);

	public Category[] getCategories();

	public boolean verifyAuthentication(String userName, String password);

	public void addCategory(String category);

}
