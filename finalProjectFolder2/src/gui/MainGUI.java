package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
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
public class MainGUI extends JFrame {
	
	private static final Dimension FRAME_SIZE = new Dimension(500, 350);
	
	private ImportExportService importExportService;
	
	private UserProfile userProfile;
	
	private static final ImportExportService IES = new ImportExportService();
	
	public String name1;
	
	public String email1;
	
	private JTextField nameTXT;
	
	private JTextField emailTXT;
	
	private JButton enterBTN;
	
	private JButton exportButton;
	
	private JButton importBTN;
	
	private FileManagementController FP;
	public MainGUI() {
		
		super("TCSS_360_Data_Iteration");

		importExportService = new ImportExportService();
		
		userProfile = new UserProfile();
		userProfile.setUserName("admin");
		userProfile.setPassword("123");
	}
	
	public void start(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
        setSize(FRAME_SIZE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
        JPanel containPanel = new JPanel();
        containPanel.setLayout(new BorderLayout());
        super.add(containPanel);
        containPanel.add(dataImplementation(), BorderLayout.NORTH);
        
        
        
 
              

        containPanel.add(dataImplementation(), BorderLayout.NORTH);  
        containPanel.add(exportImport(), BorderLayout.SOUTH);
        pack();


	}
	
	public JPanel exportImport()  {

		FP = new FileManagementController();
		JPanel contain2 = new JPanel();
		contain2.setLayout(new FlowLayout());
		importBTN = new JButton("Import");
		importBTN.setSize(150,150);
		importBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String importName = JOptionPane.showInputDialog
						("Enter User Name.");
				System.out.println(importName);
				UserProfile UP1 = FP.getUserBasedOnUserName(importName);
				if(UP1 == null) {
					JOptionPane.showMessageDialog(null,"No such User Name Exist!", "User Error!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,"Name and Email Imported!");
					JOptionPane.showMessageDialog(null,"Name: " + UP1.getUserName() + 
							"\nEmail: " + UP1.getEmail());
				}
				
				
			}
		});
		
		exportButton = new JButton("Export");
		exportButton.setSize(150, 150);
//		btnPanel.add(exportButton);
		//contain1.add(btnPanel);
		exportButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel exportDetails = new JPanel();
				exportDetails.setLayout(new GridLayout(3,1));
				exportDetails.add(new JLabel(String.format("Username: " 
						+ userProfile.getName(), ""), JLabel.LEFT));
				exportDetails.add(new JLabel(String.format("Email: " 
						+ userProfile.getEmail(),"" )));
				exportDetails.add(new JLabel(String.format("Export Succeded","" )));
				
				
				JOptionPane.showMessageDialog(null, exportDetails);
			}
		});
		contain2.add(importBTN);
		contain2.add(exportButton);
		
		
		return contain2;
		
		
		
		
	}
	
	
	
	public JPanel dataImplementation() {
		JPanel contain1 = new JPanel();
		JPanel dataEmail = new JPanel();
		JPanel dataName = new JPanel();
		JPanel btnPanel = new JPanel();
		
		
		btnPanel.setLayout(new FlowLayout());
		dataEmail.setLayout(new FlowLayout());
		contain1.setLayout(new BorderLayout());
		dataName.setLayout(new FlowLayout());
		
		JLabel nameLabel = new JLabel("Enter Name: ");
		JLabel emailLabel = new JLabel("Enter Email: ");
		
		dataEmail.add(emailLabel);
		emailTXT = new JTextField(30);
		dataEmail.add(emailTXT);
		
		dataName.add(nameLabel);
		nameTXT = new JTextField(30);
		dataName.add(nameTXT);
		
		contain1.add(dataName, BorderLayout.NORTH);
		contain1.add(dataEmail, BorderLayout.CENTER);
		
		
		enterBTN = new JButton("Enter");
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
		//contain1.add(btnPanel, BorderLayout.SOUTH);
		contain1.add(btnPanel, BorderLayout.SOUTH);
		
//		exportButton = new JButton("Export");
//		exportButton.setSize(150, 150);
//		btnPanel.add(exportButton);
//		//contain1.add(btnPanel);
//		exportButton.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				JPanel exportDetails = new JPanel();
//				exportDetails.setLayout(new GridLayout(3,1));
//				exportDetails.add(new JLabel(String.format("Username: " 
//						+ userProfile.getName(), ""), JLabel.LEFT));
//				exportDetails.add(new JLabel(String.format("Email: " 
//						+ userProfile.getEmail(),"" )));
//				exportDetails.add(new JLabel(String.format("Export Succeded","" )));
//				
//				
//				JOptionPane.showMessageDialog(null, exportDetails);
//			}
//		});
		return contain1;
		
	}

	
	
	
	
    /**
     * Main method.
     * 
     * @param theArgs arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().start();
                
           
            }
        });
    }
	
	
	
}
