package objectInterface;

import model.UserProfile;

public interface AuthenticationInterface {
	
	public boolean verifyAuthentication(String userName, String password);
	
}
