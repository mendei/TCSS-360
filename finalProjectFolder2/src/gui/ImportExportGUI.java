package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.FileManagementController;
import model.UserProfile;
import service.ImportExportService;

/**
 * This is the main gui for home-form
 *
 */
public class ImportExportGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * This is we start to instantiate all our objects 
	 * or variables to be used later in the program!
	 */
	private ImportExportService importExportService;
	
	private UserProfile userProfile;
	
	
	private JTextField nameTXT;
	
	private JTextField emailTXT;
	
	private JButton enterBTN;
	
	private JButton exportBTN;
	
	private JButton importBTN;
	
	private FileManagementController FP;
	
	/**
	 * @authors: Austin, Ivan, Anh
	 * Instantiates userProfile objects and sets the name of the frame.
	 */
	public ImportExportGUI() {
		
		
		super("TCSS_360_Data_Iteration");
		
		importExportService = new ImportExportService();
		
		
		userProfile = new UserProfile("admin", "123", "" , "");
		/*
		 * userProfile.setUserName("admin"); userProfile.setPassword("123");
		 */
	}
	
	/**
	 * @author Austin
	 * This is the method where everything is added to the 
	 * frame container.
	 */
	public void start(){
		
		// Allows us to have the exit, minimize, and max buttons in upper right hand corner.
		
		//Allows us to see the gui
		setVisible(true);
        
        
		//Makes it so the frame opens in the center of your screen
		setLocationRelativeTo(null);
        
		//WE are the tigers, so naturally we want a tiger icon!!!!:)
		setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
        
		/**
		 * This is the most important panel, it conatains everything!!!
		 * The layout is border, with entering name and email data in the 
		 * North, and all buttons in the south. We then add this main panel 
		 * the frame. 
		 */
		JPanel containPanel = new JPanel();
		containPanel.setBackground(Color.BLACK);
        containPanel.setLayout(new BorderLayout());
        super.add(containPanel);
        
        //This is where we add all the panels with name and email data and buttons.
        containPanel.add(dataImplementation(), BorderLayout.NORTH); 
        containPanel.add(exportImport(), BorderLayout.SOUTH);
        
        //Used to pack the frame down and make everything look uniform.
        pack();


	}
	
	/**
	 * @author Austin for the import button and dataImplementation method.
	 * @author Ivan for the Export Button
	 * @returns the Panel with the import and export button
	 */
	public JPanel exportImport()  {
		//Creates a File Management Object so we can import and export user data.
		FP = new FileManagementController();
		
		//This panel "contain2" holds the import and export button with a flow layout.
		JPanel contain2 = new JPanel();
		contain2.setBackground(Color.BLACK);
		contain2.setLayout(new FlowLayout());
		
		//Creating a JButton named Import and setting its size to 150X150
		importBTN = new JButton("Import");
		importBTN.setBackground(new Color(238,95,12));
		importBTN.setSize(150,150);
		
		//This is where we declare our action listener for if the user clicks on the button. 
		importBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//A pop up dialog will appear asking for a user name to import.
				String importName = JOptionPane.showInputDialog
						("Enter User Name.");				
				
				/**
				 * This is where we set a new User Profile. We set it equal to the data
				 * sent from researching the user name in file management class. 
				 */
				UserProfile UP1 = FP.getUserBasedOnUserName(importName);
				
				/**
				 * If the user name was incorrect the file management would of sent back
				 * null making the user profile object null.  Here we have an error message
				 * saying user name was incorrect. 
				 */
				
				if(UP1 == null) {
					JOptionPane.showMessageDialog(null,"No such User Name Exist!", "User Error!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					
					/**
					 * If the user name was correct, the name and email will be imported
					 * and the user will be shown both in a pop up dialog. 
					 */
					JOptionPane.showMessageDialog(null,"Name and Email Imported!");
					JOptionPane.showMessageDialog(null,"Name: " + UP1.getUserName() + 
							"\nEmail: " + UP1.getEmail());
				}
				
				
			}
		});
		
		//Here we are creating the button export and setting a size of 150 X 150
		exportBTN = new JButton("Export");
		exportBTN.setBackground(new Color(238,95,12));
		exportBTN.setSize(150, 150);

		/**
		 * We are creating the action listener so if the user clicks on the button
		 * we can export the name and email they entered. 
		 */
		exportBTN.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/**
				 * In this action listener, we are creating a panel that has the users
				 * name and email, and a message saying the the export was complete.
				 * This means that there name was entered into our info.txt file that 
				 * has all the users.
				 */
				JPanel exportDetails = new JPanel();
				exportDetails.setBackground(Color.BLACK);
				exportDetails.setLayout(new GridLayout(3,1));
				exportDetails.add(new JLabel(String.format("Username: " 
						+ userProfile.getName(), ""), JLabel.LEFT));
				exportDetails.add(new JLabel(String.format("Email: " 
						+ userProfile.getEmail(),"" )));
				exportDetails.add(new JLabel(String.format("Export Success","" )));
				
				//This is where the dialog with all the info and success message is being called.
				JOptionPane.showMessageDialog(null, exportDetails);
			}
		});
		
		//Finally we are adding the buttons into the panel.
		contain2.add(importBTN);
		contain2.add(exportBTN);
		
		//We return this panel so it can be added to the south region of the main frame.
		return contain2;
		
		
		
		
	}
	
	
	/**
	 * @author Austin
	 * @return the Panel with enter name and email, and enter button.
	 */
	public JPanel dataImplementation() {
		JPanel contain1 = new JPanel();
		contain1.setBackground(Color.BLACK);
		JPanel dataEmail = new JPanel();
		dataEmail.setBackground(Color.black);
		JPanel dataName = new JPanel();
		dataName.setBackground(Color.BLACK);
		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(Color.BLACK);
		
		
		btnPanel.setLayout(new FlowLayout());
		dataEmail.setLayout(new FlowLayout());
		contain1.setLayout(new BorderLayout());
		dataName.setLayout(new FlowLayout());
		
		JLabel nameLabel = new JLabel("Enter Name: ");
		nameLabel.setForeground(new Color(238,95,12));
		JLabel emailLabel = new JLabel("Enter Email: ");
		emailLabel.setForeground(new Color(238,95,12));
		
		dataEmail.add(emailLabel);
		emailTXT = new JTextField(30);
		dataEmail.add(emailTXT);
		
		dataName.add(nameLabel);
		nameTXT = new JTextField(30);
		dataName.add(nameTXT);
		
		contain1.add(dataName, BorderLayout.NORTH);
		contain1.add(dataEmail, BorderLayout.CENTER);
		
		
		enterBTN = new JButton("Enter");
		enterBTN.setBackground(new Color(238,95,12));
		enterBTN.setSize(150,150);
		enterBTN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				userProfile.setEmail(emailTXT.getText());
				userProfile.setName(nameTXT.getText());
				importExportService.importData(userProfile);
				
				JOptionPane.showMessageDialog(null, "Data Submitted");
			}
		});
		btnPanel.add(enterBTN);

		contain1.add(btnPanel, BorderLayout.SOUTH);
		

		return contain1;
		
	}

	
	
	
	
    /**
     * Main method.
     * @author austin
     * @param theArgs arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImportExportGUI().start();
                
           
            }
        });
    }
	
	
	
}
