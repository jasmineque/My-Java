

import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;
	JLabel lblNewLabel;
	private JButton btnLogin;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Create the Universal Variable for the Connection
	Connection dbConnection = null;

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		dbConnection = DatabaseConnection.dataConnection();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 830, 561);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserName.setBounds(47, 217, 91, 20);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(47, 280, 91, 20);
		frame.getContentPane().add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(178, 214, 199, 26);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(178, 277, 199, 26);
		frame.getContentPane().add(txtPassword);
		
		lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("LoginRed.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(451, 141, 328, 326);
		frame.getContentPane().add(lblNewLabel);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentInformation studentForm = new StudentInformation();
				studentForm.setVisible(true);
				frame.dispose();
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Que\\Downloads\\login.png"));
		btnLogin.setBounds(221, 375, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		lblNewLabel_1 = new JLabel("Student Management System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(230, 39, 343, 49);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
