package objectInterface;

import model.File;
import java.util.List;

import model.Category;

public interface FileModificationInterface {

	public void addFile(File file);

	public Category[] getCategories();
	
	
	public void addCategory(String category);

}
