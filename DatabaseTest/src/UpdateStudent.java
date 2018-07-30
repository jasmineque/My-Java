import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JComboBox cbbStudentRollNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn = null;
	
	public void displayValuesInComboBox() {
		try {
			String sql = "SELECT * FROM StudentTable";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				cbbStudentRollNo.addItem(result.getString("ID"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public UpdateStudent() {
		conn = DatabaseConnection.dataConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 575);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("New");
		menuBar.add(mnNew);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitel = new JLabel("STUDENT MANAGEMENT SYSTEM");
		lblTitel.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitel.setBounds(191, 46, 370, 26);
		contentPane.add(lblTitel);
		
		JLabel lblUpdateStudentInformation = new JLabel("UPDATE STUDENT INFORMATION");
		lblUpdateStudentInformation.setBounds(260, 88, 251, 20);
		contentPane.add(lblUpdateStudentInformation);
		
		JLabel lblStudentRollNo = new JLabel("Student Roll No");
		lblStudentRollNo.setBounds(68, 167, 111, 20);
		contentPane.add(lblStudentRollNo);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(68, 215, 111, 20);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(68, 261, 111, 20);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(68, 309, 111, 20);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(68, 361, 111, 20);
		contentPane.add(lblEmail);
		
		cbbStudentRollNo = new JComboBox();
		cbbStudentRollNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sqlCommand = "SELECT * FROM StudentTable WHERE ID = ?";
					PreparedStatement statement = conn.prepareStatement(sqlCommand);
					statement.setString(1, cbbStudentRollNo.getSelectedItem().toString());
					ResultSet result = statement.executeQuery();
					while (result.next()) {
						txtName.setText(result.getString("sName"));
						txtAddress.setText(result.getString("sAddress"));
						txtPhone.setText(result.getString("sPhone"));
						txtEmail.setText(result.getString("sEmail"));
					}
					// close
					result.close();
					statement.close();
				} catch (Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		cbbStudentRollNo.setBounds(241, 164, 273, 26);
		contentPane.add(cbbStudentRollNo);
		
		txtName = new JTextField();
		txtName.setBounds(241, 212, 273, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(241, 258, 273, 26);
		contentPane.add(txtAddress);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(241, 306, 273, 26);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(241, 358, 273, 26);
		contentPane.add(txtEmail);
		
		JButton btnUpdateStudentInformation = new JButton("Update Student Information");
		btnUpdateStudentInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirmationResult = JOptionPane.showConfirmDialog(null, "Do you really want to update the Information?", 
						"Student Information System Update", JOptionPane.YES_NO_OPTION);
				if (confirmationResult == 0) {
					try {
						String sqlUpdateCommand = "UPDATE StudentTable SET sName = '" + txtName.getText() + "', sAddress = '" 
								+ txtAddress.getText() + "', sPhone = '" + txtPhone.getText() + "', sEmail = '" + txtEmail.getText() 
								+ "' WHERE ID = '" + cbbStudentRollNo.getSelectedItem() + "'";
						
						PreparedStatement statement = conn.prepareStatement(sqlUpdateCommand);
						statement.execute();
						JOptionPane.showMessageDialog(null, "Record updated successfully");
						statement.close();
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		btnUpdateStudentInformation.setBounds(265, 424, 231, 29);
		contentPane.add(btnUpdateStudentInformation);
		displayValuesInComboBox();
	}
}
