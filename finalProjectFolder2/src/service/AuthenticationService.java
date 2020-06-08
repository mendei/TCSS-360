package service;

import controller.FileManagementController;
import model.UserProfile;
import objectInterface.AuthenticationInterface;

/**
 * Proving the methods for GUI layer to communicate with File Controller about authentication.
 * 
 * @author Anh Tran
 */
public class AuthenticationService implements AuthenticationInterface {

	private FileManagementController fileController;

	public AuthenticationService() {
		fileController = new FileManagementController();
	}

	@Override
	public boolean verifyAuthentication(String userName, String password) {
		return fileController.verifyAuthentication(userName, password);
	}

}
