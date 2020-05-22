package controller;

import model.UserProfile;
import objectInterface.FileOperationInterface;

public class FileManagementController implements FileOperationInterface {

	/***
	 * Accessing the file to export the data based on user name
	 */
	@Override
	public UserProfile exportSetting(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Accessing the file to import userProfile
	 */
	@Override
	public boolean importSetting(UserProfile userProfile) {
		// TODO Auto-generated method stub
		return false;
	}

}
