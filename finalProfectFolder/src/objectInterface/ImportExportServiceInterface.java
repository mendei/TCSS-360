package objectInterface;

import model.UserProfile;

public interface ImportExportServiceInterface {
	
	public void importData(UserProfile userProfile);
	
	public UserProfile getUserBasedOnUserName(String userName);

	public void importData(UserProfile userProfile);

	
}
