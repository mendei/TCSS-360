package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CellPhoneGUI {
	
	public static void createWindow() {
		
		JFrame frame = new JFrame("Panel Example");
		JPanel panel = new JPanel();
		panel.setBounds(40,80,200,200);
		panel.setBackground(Color.gray);
		frame.add(panel);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		
		createWindow();
		
	}

}
