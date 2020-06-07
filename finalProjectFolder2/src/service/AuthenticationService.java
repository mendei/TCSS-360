package service;

import controller.FileManagementController;
import model.UserProfile;
import objectInterface.AuthenticationInterface;

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
