/**
 *This is a version info class
 *and it is supposed to be called
 *when opening the about UI to tell 
 *the user who are the designers, and
 *other info. 
 */

/**
 * @author Ivan, Austin, Khaled, Anh
 *
 */
public class VersionInfo {
	public static String DESIGNER1;
	public static String DESIGNER2;
	public static String DESIGNER3;
	public static String DESIGNER4;
	
	
	public VersionInfo() {
		DESIGNER1 = getD1();
		DESIGNER2 = getD2();
		DESIGNER3 = getD3();
		DESIGNER4 = getD4();
	}
	
	public String getD1() {
		return "Austin Scott";
	}
	
	public String getD2() {
		return "Ivan Mendez";
	}
	
	public String getD3() {
		return "Khaled Alashor";
	}
	
	
	public String getD4() {
		return "Anh Tu Tran";
	}
}
