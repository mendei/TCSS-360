package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.UserProfile;
import service.AuthenticationService;

public class LoginGUI extends JDialog {
	
	private AuthenticationService authenticationService = new AuthenticationService();
	
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	private File file;
	
	
	public LoginGUI() {
		this.setTitle("Authentication");
		this.setLayout(new GridLayout(6, 1));
		
		JPanel userNamePnl = new JPanel();
		userNamePnl.add(new JLabel("Username: "));
		userNameTxt = new JTextField(15);
		userNamePnl.add(userNameTxt);
		this.add(userNamePnl);

		JPanel passwordPnl = new JPanel();
		passwordPnl.add(new JLabel("Password: "));
		passwordTxt = new JPasswordField(15);
		passwordPnl.add(passwordTxt);
		this.add(passwordPnl);

		JPanel btnPnl = new JPanel();
		JButton loginBtn = new JButton("Login as Admin");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(userNameTxt.getText().equals("") || passwordTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter username and password!");
					return;
				}
				if(authenticationService.verifyAuthentication(userNameTxt.getText(), passwordTxt.getText())) {
					new HomeScreen().start();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
				}
			}
		});
		
		JButton userLoginBtn = new JButton("Login as User");
		userLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userNameTxt.getText().equals("") || passwordTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter username and password!");
					return;
				}
				if(authenticationService.verifyAuthentication(userNameTxt.getText(), passwordTxt.getText())) {
					new HomeScreen().start();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
				}
			}
		});
		
		JButton createUserBtn = new JButton("Create User Account");
		createUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userNameTxt.getText().equals("") || passwordTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter username and password!");
					return;
				}
				if(authenticationService.verifyAuthentication(userNameTxt.getText(), passwordTxt.getText())) {
					JOptionPane.showMessageDialog(null, "User already exist.","Error Message", JOptionPane.ERROR_MESSAGE);
				} 
				if(!authenticationService.verifyAuthentication(userNameTxt.getText(), passwordTxt.getText())){
					file = new File("src/userInfo/userInfo.txt");
					FileWriter fw = null;
					BufferedWriter br = null;
					try {
						fw = new FileWriter(file,true);
						br = new BufferedWriter(fw);
						br.append("\n" + userNameTxt.getText() + "," + passwordTxt.getText() + ",N/A,N/A");
						br.flush();
						fw.close();
						br.close();
					} catch(IOException i) {
						i.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "User account created!");
					new HomeScreen().start();
					dispose();
				}
				
			}
		});
		

		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userNameTxt.setText("");
				passwordTxt.setText("");
			}
		});
		
		btnPnl.add(loginBtn);
		btnPnl.add(userLoginBtn);
		btnPnl.add(createUserBtn);
		btnPnl.add(resetBtn);
		
		this.add(btnPnl);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LoginGUI();
			}
		});
	}

}
