package objectInterface;

import java.io.File;

import model.UserProfile;

/***
 * This interface will provide the methods to manipulate such as add, delete, modify or access to the file system
 * Any method is implemented by FileManagementController must be declared here.
 * 
 */
public interface FileOperationInterface {
	
	public UserProfile exportSetting(String userName);
	
	public void importSetting(UserProfile userProfile);

	public UserProfile getUserBasedOnUserName(String userName);
	
	public File[] getListOfFileByFolder(String path);
	
}
