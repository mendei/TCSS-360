package objectInterface;

import model.UserProfile;

/**
 * Prototype interface for authentication.
 * 
 * @author Anh Tran
 */
public interface AuthenticationInterface {
	
	public boolean verifyAuthentication(String userName, String password);
	
}
