package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public LoginGUI() {
		this.setTitle("Authentication");
		this.setLayout(new GridLayout(4, 1));
		
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
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(userNameTxt.getText().equals("") || passwordTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter username and password!");
					return;
				}
				if(authenticationService.verifyAuthentication(userNameTxt.getText(), passwordTxt.getText())) {
					new HomeScreen().createWindow();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong username or password!");
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
