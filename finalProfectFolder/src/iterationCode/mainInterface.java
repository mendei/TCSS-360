package iterationCode;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * This Class the main Interface that will have the 
 * Name, Email, any other information, and option to 
 * import and export data.  
 */

/**
 * @author Austin
 *
 */
public class mainInterface extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private static final Dimension FRAME_SIZE = new Dimension(750, 350);
	
	public mainInterface() {
		super("TCSS_360_Data_Iteration");
	}
	
	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(FRAME_SIZE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());
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
                new mainInterface().start();
            }
        });
    }

}
