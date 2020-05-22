package gui;

import javax.swing.JFrame;

import model.UserProfile;
import objectInterface.ImportExportServiceInterface;
import service.ImportExportService;

public class ImportGUI extends JFrame {
	
	UserProfile userProfile; //the information of user who loged in to do the export
	ImportExportServiceInterface importExportService; //the service provide method to export when user click
	
	public ImportGUI () {
		importExportService = new ImportExportService();
	}
	
}
