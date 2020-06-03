package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeScreen {
	
public  void createWindow() {
		
		JFrame frame = new JFrame("Panel Example");
		JPanel containPanel = new JPanel();
		containPanel.setLayout(new BorderLayout());
		
		containPanel.add(taskbar(), BorderLayout.NORTH);
		containPanel.add(fileDirectory(), BorderLayout.WEST);
		containPanel.add(documentViewer(), BorderLayout.EAST);
		
		containPanel.setSize(750,600);
		frame.add(containPanel);
		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public JPanel taskbar() {
		
		JPanel taskbarPanel = new JPanel();
		JLabel label = new JLabel("Taskbar");
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchGUI().start();
			}
		});
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFileGUI().start();
			}
		});
		
		taskbarPanel.add(searchButton);
		taskbarPanel.add(addButton);
		taskbarPanel.add(label);
		
		return taskbarPanel;
	}
	
	public JPanel fileDirectory() {
		
		JPanel fileDirectoryPanel= new JPanel();
		fileDirectoryPanel.setBounds(40,80,600,400);
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
