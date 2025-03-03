package GUI;

import javax.swing.*;

import Login.LoginBackend;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.prefs.Preferences;

//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;

public class LoginGUI extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		
	LoginGUI logingui = new LoginGUI();
	}
	
	private static final JOptionPane OptionPane = null;
	JFrame frame;
	JLabel titleLabel = new JLabel("LOGIN");
	JLabel userLabel = new JLabel("Enter Username:");
	JLabel passwordLabel = new JLabel("Enter Password:");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JButton backButton = new JButton("BACK");
	JCheckBox showPassword = new JCheckBox("Show Password");


	LoginGUI()
	{
		//Calling methods inside constructor.
		createWindow();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
	}

	public void createWindow()
	{
		frame = new JFrame();
		frame.setTitle("Login Form");

		frame.setBounds(100,100,900,750);
		//frame.getContentPane().setBackground(Color.pink);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
	}

	public void setLocationAndSize()
	{
		//Setting location and Size of each components using setBounds() method.
		// setBounds (x, y, width, height)
		titleLabel.setBounds(100,50,3000,30);
		userLabel.setBounds(50,150,150,30);
		passwordLabel.setBounds(50,220,100,30);
		userTextField.setBounds(175,150,150,30);
		passwordField.setBounds(175,220,150,30);
		showPassword.setBounds(150,250,150,30);
		loginButton.setBounds(50,300,100,30);
		resetButton.setBounds(200,300,100,30);
		backButton.setBounds(125,350,100,30);
	}

	public void addComponentsToContainer()
	{
		//Adding each components to the Container
		frame.add(titleLabel);
		frame.add(userLabel);
		frame.add(passwordLabel);
		frame.add(userTextField);
		frame.add(passwordField);
		frame.add(showPassword);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(backButton);
	}

	public void addActionEvent()
	{
		//adding Action listener to components
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
		backButton.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		//Coding Part of LOGIN button
		if (e.getSource() == loginButton) {
			

				String userText;
				String pwdText;
				userText = userTextField.getText();
				pwdText = passwordField.getText();
				LoginBackend login = new LoginBackend();

				if (login.doLogin(userText, pwdText)) {
					JOptionPane.showMessageDialog(this, "Login Successful");
					frame.dispose();
					
				} else {
					JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}

		}

		//Coding Part of RESET button
		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}

		//Coding Part of showPassword JCheckBox
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}
		}

		if (e.getSource() == backButton) {
			frame.dispose();
		}
	}
}
