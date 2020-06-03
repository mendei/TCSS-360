package model;

/**
 * Category Model.
 * 
 * @author Anh Tran
 */
public class Category {

	private String categoryName;

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String toString() {
		return categoryName;
	}

}
