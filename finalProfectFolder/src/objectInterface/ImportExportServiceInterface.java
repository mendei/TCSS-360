package objectInterface;

import model.UserProfile;

public interface ImportExportServiceInterface {
	
	public UserProfile exportData(String userName);
	
	public boolean importData(UserProfile userProfile);
	
}
