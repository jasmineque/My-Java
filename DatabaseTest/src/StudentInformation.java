import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInformation extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentName;
	private JTextField txtStudentAddress;
	private JTextField txtStudentPhone;
	private JTextField txtStudentEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInformation frame = new StudentInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection dbConnection = null;

	/**
	 * Create the frame.
	 */
	public StudentInformation() {
		
		// Create the instance of this connection
		dbConnection = DatabaseConnection.dataConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 831, 31);
		contentPane.add(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Student Information");
		mnNew.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Class Information");
		mnNew.add(mntmNewMenuItem_1);
		
		JMenuItem mntmFeeInformation = new JMenuItem("Fee Information");
		mnNew.add(mntmFeeInformation);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmStudentInformation = new JMenuItem("Student Information");
		mnView.add(mntmStudentInformation);
		
		JMenu mnDelete = new JMenu("Delete");
		menuBar.add(mnDelete);
		
		JMenu mnNewMenu = new JMenu("Student");
		mnDelete.add(mnNewMenu);
		
		JMenuItem mntmMsc = new JMenuItem("MSC");
		mnNewMenu.add(mntmMsc);
		
		JMenuItem mntmBsc = new JMenuItem("BSC");
		mnNewMenu.add(mntmBsc);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmShortCourses = new JMenuItem("Short courses");
		mnNewMenu.add(mntmShortCourses);
		
		JMenuItem mntmTeacher = new JMenuItem("Teacher");
		mnDelete.add(mntmTeacher);
		
		JMenu mnMisc = new JMenu("Misc");
		menuBar.add(mnMisc);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.setIcon(new ImageIcon("C:\\Users\\Que\\Downloads\\login.png"));
		mnMisc.add(mntmChangePassword);
		
		JMenu mnBackgroundColor = new JMenu("Background Color");
		mnMisc.add(mnBackgroundColor);
		
		JRadioButtonMenuItem rdbtnmntmRed = new JRadioButtonMenuItem("Red");
		mnBackgroundColor.add(rdbtnmntmRed);
		
		JRadioButtonMenuItem rdbtnmntmBlue = new JRadioButtonMenuItem("Blue");
		mnBackgroundColor.add(rdbtnmntmBlue);
		
		JRadioButtonMenuItem rdbtnmntmGreen = new JRadioButtonMenuItem("Green");
		mnBackgroundColor.add(rdbtnmntmGreen);
		
		JSeparator separator_1 = new JSeparator();
		mnMisc.add(separator_1);
		
		JLabel lblStudentForm = new JLabel("STUDENT MANAGEMENT SYSTEM");
		lblStudentForm.setBounds(366, 41, 376, 27);
		lblStudentForm.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblStudentForm);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(110, 155, 100, 20);
		contentPane.add(lblStudentName);
		
		JLabel lblStudentAddress = new JLabel("Student Address");
		lblStudentAddress.setBounds(110, 210, 116, 20);
		contentPane.add(lblStudentAddress);
		
		JLabel lblStudentPhone = new JLabel("Student Phone");
		lblStudentPhone.setBounds(110, 267, 103, 20);
		contentPane.add(lblStudentPhone);
		
		JLabel lblStudentEmail = new JLabel("Student Email");
		lblStudentEmail.setBounds(110, 331, 98, 20);
		contentPane.add(lblStudentEmail);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(265, 152, 240, 26);
		contentPane.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtStudentAddress = new JTextField();
		txtStudentAddress.setBounds(265, 207, 240, 26);
		contentPane.add(txtStudentAddress);
		txtStudentAddress.setColumns(10);
		
		txtStudentPhone = new JTextField();
		txtStudentPhone.setBounds(265, 264, 240, 26);
		contentPane.add(txtStudentPhone);
		txtStudentPhone.setColumns(10);
		
		txtStudentEmail = new JTextField();
		txtStudentEmail.setBounds(265, 328, 240, 26);
		contentPane.add(txtStudentEmail);
		txtStudentEmail.setColumns(10);
		
		JButton btnSaveInformation = new JButton("Save Information");
		btnSaveInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try {
					String sqlQuery = "INSERT INTO StudentTable (sName, sAddress, sPhone, sEmail) VALUES (?, ?, ?, ?)";
					PreparedStatement statement = dbConnection.prepareStatement(sqlQuery);
					// get the values from the JTextField
					statement.setString(1, txtStudentName.getText());
					statement.setString(2, txtStudentAddress.getText());
					statement.setString(3, txtStudentPhone.getText());
					statement.setString(4, txtStudentEmail.getText());
					// Execute the command
					statement.execute();
					
					JOptionPane.showMessageDialog(null, "Record saved successfully.");
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			
			}
		});
		btnSaveInformation.setBounds(296, 409, 155, 29);
		contentPane.add(btnSaveInformation);
	}
}
