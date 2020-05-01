
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
        classAndMethodTitlePnl.setBorder(BorderFactory.createLineBorder(Color.black));
        classAndMethodTitlePnl.add(new JLabel("Classes And Methods", JLabel.CENTER));

        JPanel classAndMethodContentPnl = new JPanel();
        classAndMethodContentPnl.setBorder(BorderFactory.createLineBorder(Color.black));
        classAndMethodContentPnl.setLayout(new GridLayout(7, 1));
        classAndMethodContentPnl.add(new JLabel(""));
        classAndMethodContentPnl.add(new JLabel("Method class 1", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("Method class 2", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("Method class 3", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("Method class 4", JLabel.CENTER));
        classAndMethodContentPnl.add(new JLabel("..............", JLabel.CENTER));

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
