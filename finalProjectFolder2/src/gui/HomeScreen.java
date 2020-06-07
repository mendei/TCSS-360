package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeScreen {

	public void createWindow() {

		JFrame frame = new JFrame("Home Screen");
		// WE are the tigers, so naturally we want a tiger icon!!!!:)
		frame.setIconImage(new ImageIcon(getClass().getResource("/Icon/Icon.png")).getImage());

		JPanel containPanel = new JPanel();
		containPanel.setLayout(new BorderLayout());

		containPanel.add(taskbar(), BorderLayout.NORTH);
		containPanel.add(fileDirectory(), BorderLayout.WEST);
		containPanel.add(documentViewer(), BorderLayout.EAST);

		containPanel.setSize(750, 600);
		frame.add(containPanel);
		frame.setSize(800, 600);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

	public JPanel taskbar() {

		JPanel taskbarPanel = new JPanel();
		
		ImageIcon searchIcon = new ImageIcon("src\\Icon\\SearchIcon.png");
		Image img = searchIcon.getImage();
		Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		searchIcon = new ImageIcon(newimg);
		JButton searchButton = new JButton(searchIcon);
		searchButton.setBackground(Color.WHITE);
		searchButton.setOpaque(true);
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchGUI().start();
			}
		});

		ImageIcon addFileIcon = new ImageIcon("src\\Icon\\AddFile.png");
		img = addFileIcon.getImage();
		newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		addFileIcon = new ImageIcon(newimg);
		JButton addButton = new JButton(addFileIcon);
		addButton.setBackground(Color.WHITE);
		addButton.setOpaque(true);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFileGUI().start();
			}
		});
		
		ImageIcon aboutIcon = new ImageIcon("src\\Icon\\AboutIcon.png");
		img = aboutIcon.getImage();
		newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		aboutIcon = new ImageIcon(newimg);
		JButton aboutButton = new JButton(aboutIcon);
		aboutButton.setBackground(Color.WHITE);
		aboutButton.setOpaque(true);
		aboutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutScreenGUI().start();
			}
		});
		
		ImageIcon importExportIcon = new ImageIcon("src\\Icon\\ImportExportIcon.jpg");
		img = importExportIcon.getImage();
		newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		importExportIcon = new ImageIcon(newimg);
		JButton importExportButton = new JButton(importExportIcon);
		importExportButton.setBackground(Color.WHITE);
		importExportButton.setOpaque(true);
		importExportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ImportExportGUI().start();
			}
		});
		
		taskbarPanel.add(searchButton);
		taskbarPanel.add(addButton);
		taskbarPanel.add(aboutButton);
		taskbarPanel.add(importExportButton);
		//taskbarPanel.add(label);

		return taskbarPanel;
	}

	public JPanel fileDirectory() {

		JPanel fileDirectoryPanel = new JPanel();
		fileDirectoryPanel.setBounds(40, 80, 600, 400);
		fileDirectoryPanel.setBackground(Color.gray);
		JLabel label = new JLabel("File Directory");
		fileDirectoryPanel.add(label);

		return fileDirectoryPanel;

	}

	public JPanel documentViewer() {
		JPanel docViewerPanel = new JPanel();
		JLabel label = new JLabel("Document Viewer");

		docViewerPanel.add(label);
		return docViewerPanel;

	}

	public static void main(String args[]) {

		HomeScreen homeScreen = new HomeScreen();
		homeScreen.createWindow();

	}

}
