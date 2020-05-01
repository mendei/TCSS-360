/**
 * 
 */

/**
 * @author austi
 *
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class UserInterface extends JFrame {

	private static final Dimension FRAME_SIZE = new Dimension(400, 400);
	
	public UserInterface() {
		super("TCSS-360 Tigers About Screen");
		
	}
	
	public void start() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(FRAME_SIZE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
        
        //NEED TO ADD PANEL
        //NEED TO ADD LABEL WITH DESIGNER INFO
        //CALLED FROM VERSIONINFO CLASS.
        
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
	            	new UserInterface().start();
	            }
	        });
	    }

	}

