package model;

/**
 * File Model.
 * 
 * @author Anh Tran
 */
public class File {

	private String path;
	private String fileName;
	private Category category;
	
	
	public File(String path, String fileName, Category category) {
		super();
		this.path = path;
		this.fileName = fileName;
		this.category = category;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
