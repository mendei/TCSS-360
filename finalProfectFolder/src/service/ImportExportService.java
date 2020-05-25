package service;

import controller.FileManagementController;
import model.UserProfile;
import objectInterface.ImportExportServiceInterface;

public class ImportExportService implements ImportExportServiceInterface {

	FileManagementController fileController;

	public ImportExportService() {
		fileController = new FileManagementController();
	}


	@Override
	public void importData(UserProfile userProfile) {
		fileController.importSetting(userProfile);
	}

}
