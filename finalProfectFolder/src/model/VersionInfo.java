package model;
/**
 * This is a version info class and it is supposed to be called when opening the
 * about UI to tell the user who are the designers, and other info.
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
    public static String GITHUB;

    public VersionInfo() {

    }

    public static String getD1() {
        return DESIGNER1 = "Austin Scott";
    }

    public static String getD2() {
        return DESIGNER2 = "Ivan Mendez";
    }

    public static String getD3() {
        return DESIGNER3 = "Khaled Alashor";
    }

    public static String getD4() {
        return DESIGNER4 = "Anh Tu Tran";
    }

    public static String getGitHub() {
        return "https://tcss-360-tigers.github.io/TCSS-360/";
    }

}
