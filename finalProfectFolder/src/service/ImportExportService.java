package service;

import controller.FileManagementController;
import model.UserProfile;
import objectInterface.ImportExportServiceInterface;

public class ImportExportService implements ImportExportServiceInterface {

	FileManagementController fileController;

	public ImportExportService() {
		fileController = new FileManagementController();
	}

	/***
	 * Accept the data from the GUI and call the FileManagementController.
	 */
	@Override
	public UserProfile exportData(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void importData(UserProfile userProfile) {
		fileController.importSetting(userProfile);
	}

}
