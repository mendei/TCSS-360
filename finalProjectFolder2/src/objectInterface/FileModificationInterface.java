package objectInterface;

import model.File;
import java.util.List;

import model.Category;

/**
 * Prototype interface for File Modification.
 * 
 * @author Anh Tran
 */
public interface FileModificationInterface {

	public void addFile(File file);

	public Category[] getCategories();
	
	
	public void addCategory(String category);

}
