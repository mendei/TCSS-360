package service;

import java.io.File;

import controller.FileManagementController;
import objectInterface.SearchFileServiceInterface;

/**
 * Proving the methods for GUI layer to communicate with File Controller about searching file related.
 * 
 * @author Anh Tran
 */
public class SearchFileService implements SearchFileServiceInterface {

	private FileManagementController fileController;

	public SearchFileService() {
		fileController = new FileManagementController();
	}
	
	@Override
	public File[] getListOfFileByFolder(String path) {
		return fileController.getListOfFileByFolder(path);
	}
	
	
	
}
