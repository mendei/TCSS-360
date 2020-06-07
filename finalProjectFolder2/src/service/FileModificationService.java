package service;

import model.File;

import controller.FileManagementController;
import model.Category;
import objectInterface.FileModificationInterface;

/**
 * Proving the methods for GUI layer to communicate with File Controller.
 * 
 * @author Anh Tran
 */
public class FileModificationService implements FileModificationInterface {
	
	private FileManagementController fileController;
	
	public FileModificationService() {
		fileController = new FileManagementController();
	}
	
	@Override
	public void addFile(File file) {
		fileController.addFile(file);
	}

	@Override
	public Category[] getCategories() {
		return fileController.getCategories();
	}

	@Override
	public void addCategory(String category) {
		fileController.addCategory(category);
	}


	
}
