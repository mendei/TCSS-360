package objectInterface;

import java.io.File;

/**
 * Prototype interface for Search File.
 * 
 * @author Anh Tran
 */
public interface SearchFileServiceInterface {
	
	public File[] getListOfFileByFolder(String path);
	
}
