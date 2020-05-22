package aboutScreenCode;

/**
 * 
 */

/**
 * @author austi
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInterface extends JFrame {

    private static final Dimension FRAME_SIZE = new Dimension(750, 350);

    public UserInterface() {
        super("TCSS-360 Tigers About Screen");

    }

    public void start() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(FRAME_SIZE);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());

        JPanel containPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(1, 2);
        containPanel.setLayout(gridLayout);
        containPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        containPanel.add(createTeamInfoPanel());
        containPanel.add(createClassAndMethodPanel());

        this.add(containPanel);

        // NEED TO POST TO GIT
        // NEED TO ADD PANEL
        // NEED TO ADD LABEL WITH DESIGNER INFO
        // CALLED FROM VERSIONINFO CLASS.

    }

    private JPanel createTeamInfoPanel() {

        JPanel teamInfoPnl = new JPanel();
        teamInfoPnl.setLayout(new BorderLayout());

        JPanel designerPnl = new JPanel();
        designerPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        designerPnl.add(new JLabel("Designers:", JLabel.CENTER));

        JPanel designerNamePnl = new JPanel();
        designerNamePnl.setBorder(BorderFactory.createLineBorder(Color.black));
        designerNamePnl.setLayout(new GridLayout(7, 1));
        designerNamePnl.add(new JLabel(""));
        designerNamePnl.add(new JLabel(VersionInfo.getD1(), JLabel.CENTER));
        designerNamePnl.add(new JLabel(VersionInfo.getD2(), JLabel.CENTER));
        designerNamePnl.add(new JLabel(VersionInfo.getD3(), JLabel.CENTER));
        designerNamePnl.add(new JLabel(VersionInfo.getD4(), JLabel.CENTER));

        JPanel githubPnl = new JPanel();
        githubPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        githubPnl.add(new JLabel("GitHub: " + VersionInfo.getGitHub()));

        teamInfoPnl.add(designerPnl, BorderLayout.NORTH);
        teamInfoPnl.add(designerNamePnl, BorderLayout.CENTER);
        teamInfoPnl.add(githubPnl, BorderLayout.SOUTH);

        return teamInfoPnl;
    }

    private JPanel createClassAndMethodPanel() {

        JPanel classAndMethodPnl = new JPanel();
        classAndMethodPnl.setLayout(new BorderLayout());

        JPanel classAndMethodTitlePnl = new JPanel();
        classAndMethodTitlePnl.setBorder(BorderFactory.createLineBorder(Color.black));
        classAndMethodTitlePnl.add(new JLabel("Classes And Methods", JLabel.CENTER));

        JPanel classAndMethodContentPnl = new JPanel();
        classAndMethodContentPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        classAndMethodContentPnl.setLayout(new GridLayout(1, 2));
        
        JPanel adminClassPnl = new JPanel();
        adminClassPnl.setLayout(new BorderLayout());
        
        JPanel adminNamePnl = new JPanel();
        adminNamePnl.setBorder(BorderFactory.createLineBorder(Color.black));
        adminNamePnl.add(new JLabel("Administrator"), JLabel.CENTER);
        
        JPanel adminMethodPnl = new JPanel();
        adminMethodPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        adminMethodPnl.setLayout(new GridLayout(5,1));
        adminMethodPnl.add(new JLabel(String.format("%10s+ addFile()", ""), JLabel.LEFT));
        adminMethodPnl.add(new JLabel(String.format("%10s+ removeFile()", ""), JLabel.LEFT));
        adminMethodPnl.add(new JLabel(String.format("%10s+ searchDocuments()", ""), JLabel.LEFT));
        adminMethodPnl.add(new JLabel(String.format("%10s+ downloadDocument()", ""), JLabel.LEFT));
        adminMethodPnl.add(new JLabel(String.format("%10s+ acceptVisitor()", ""), JLabel.LEFT));
        
        adminClassPnl.add(adminNamePnl, BorderLayout.NORTH);
        adminClassPnl.add(adminMethodPnl, BorderLayout.CENTER);
        
        JPanel visitorClassPnl = new JPanel();
        visitorClassPnl.setLayout(new BorderLayout());
        
        JPanel visitorNamePnl = new JPanel();
        visitorNamePnl.setBorder(BorderFactory.createLineBorder(Color.black));
        visitorNamePnl.add(new JLabel("Visitor"), JLabel.CENTER);
        
        JPanel visitorMethodPnl = new JPanel();
        visitorMethodPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        visitorMethodPnl.setLayout(new GridLayout(5,1));
        
        visitorMethodPnl.add(new JLabel(String.format("%10s+ login()", ""), JLabel.LEFT));
        visitorMethodPnl.add(new JLabel(String.format("%10s+ searchDocuments()", ""), JLabel.LEFT));
        visitorMethodPnl.add(new JLabel(String.format("%10s+ downloadDocuments()", ""), JLabel.LEFT));
        
        visitorClassPnl.add(visitorNamePnl, BorderLayout.NORTH);
        visitorClassPnl.add(visitorMethodPnl, BorderLayout.CENTER);
        
        classAndMethodContentPnl.add(adminClassPnl);
        classAndMethodContentPnl.add(visitorClassPnl);
        
        /*
        classAndMethodContentPnl.add(new JLabel(""));
        classAndMethodContentPnl.add(new JLabel("Method class 1", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("Method class 2", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("Method class 3", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("Method class 4", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("..............", JLabel.CENTER));
        */

        classAndMethodPnl.add(classAndMethodTitlePnl, BorderLayout.NORTH);
        classAndMethodPnl.add(classAndMethodContentPnl, BorderLayout.CENTER);

        return classAndMethodPnl;
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
