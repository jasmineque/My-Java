import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteStudent extends JFrame {

	private JPanel contentPane;
	private JComboBox cbbStudentID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteStudent frame = new deleteStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;

	/**
	 * Create the frame.
	 */
	public deleteStudent() {
		
		// Create the instance of the connection
		conn = DatabaseConnection.dataConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 408);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSchoolManagementSystem = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lblSchoolManagementSystem.setFont(new Font("Arial", Font.BOLD, 20));
		lblSchoolManagementSystem.setBounds(120, 16, 322, 24);
		contentPane.add(lblSchoolManagementSystem);
		
		JLabel lblStudentRollNo = new JLabel("Student Roll No.");
		lblStudentRollNo.setBounds(41, 112, 139, 20);
		contentPane.add(lblStudentRollNo);
		
		cbbStudentID = new JComboBox();
		cbbStudentID.setBounds(227, 109, 236, 26);
		contentPane.add(cbbStudentID);
		
		JButton btnDeleteStudent = new JButton("Delete Student");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sqlCommand = "DELETE FROM StudentTable WHERE ID = '" + cbbStudentID.getSelectedItem() + "'";
					PreparedStatement statement = conn.prepareStatement(sqlCommand);
					statement.execute();
					JOptionPane.showMessageDialog(null, "Student Record deleted successfully");
				} catch(Exception e) {
					JOptionPane.showConfirmDialog(null, e);
				}
			}
		});
		btnDeleteStudent.setBounds(229, 210, 135, 29);
		contentPane.add(btnDeleteStudent);
		
		displayValuesInComboBox();
	}
	
	// Create a method to display the values in the Combobox
		public void displayValuesInComboBox() {
			try {
				String sql = "SELECT * FROM StudentTable";
				PreparedStatement statement = conn.prepareStatement(sql);
				
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					cbbStudentID.addItem(result.getString("ID"));
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
}
