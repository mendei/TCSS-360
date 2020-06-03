package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AddFile extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton addBTN;
	
	private JFileChooser chooser;
	
	private JPanel containerPNL;
	
	private Image img;
	
	private String fileType;
	
	
	
	private String fileName;
	
	
	
	
	public AddFile() {
		super("Add Button");
		
	}
	
	/**
	 * @author Austin
	 * @date 1 June 2020
	 * This method adds the addBTN to the main conatainer.
	 */
	public void start() {
		// Allows us to have the exit, minimize, and max buttons in upper right hand corner.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		//Allows us to see the gui
		setVisible(true);
		
		        
		//Makes it so the frame opens in the center of your screen
		setLocationRelativeTo(null);
		        
		//WE are the tigers, so naturally we want a tiger icon!!!!:)
		setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
		
		containerPNL = new JPanel();
		
		containerPNL.setLayout(new BorderLayout());
		
		containerPNL.add(addFile(), BorderLayout.CENTER);
		this.add(containerPNL);
		pack();
		
	}
	
	/**
	 * @author Austin
	 * @date 1 June 2020
	 * @return an Add Button that uploads files. 
	 */
	private JButton addFile() {
		
		addBTN = new JButton();
		addBTN.setSize(new Dimension(100,100));
		try {
			img = ImageIO.read(getClass().getResource("/Icon/addFile.jpg"));
			Image newImg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
			
			addBTN.setIcon(new ImageIcon(newImg));
		} catch (Exception ex) {
			System.out.println(ex);
		}

		
		//addBTN.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		addBTN.setContentAreaFilled(false);
		addBTN.setFocusPainted(false);
		addBTN.setOpaque(false);
		
		
		addBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileType = JOptionPane.showInputDialog
						("Enter File Type: " + "\n(pdf, docx, jpg, png, txt,url)");
		        chooser = new JFileChooser(".");
		        chooser.setDialogTitle("Upload File");
		        final int result = chooser.showSaveDialog(containerPNL);
		        if (result == JFileChooser.APPROVE_OPTION)
		        {
		          final File selectedFile = chooser.getSelectedFile();
		          fileName = selectedFile.getAbsolutePath();
		          System.out.println(fileName);
		        }
			}
		});
		
		
		return addBTN;
		
		
		
	}
	
	/**
	 * @author Austin
	 * @Date 2 June 2020
	 * @return the user input for File type
	 */
	public String getFileType() {
		return this.fileType;
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
                new AddFile().start();
                
           
            }
        });
    }
}
