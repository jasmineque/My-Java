import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class displayStudentInformation extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayStudentInformation frame = new displayStudentInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Creating the Connection Variable
		Connection dbConnection;

	/**
	 * Create the frame.
	 */
	public displayStudentInformation() {
		
		// Create the instance
		dbConnection = DatabaseConnection.dataConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 139, 31);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmStudentInformation = new JMenuItem("Student Information");
		mntmStudentInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentInformation sform = new StudentInformation();
//				sform.show();
				sform.setVisible(true);
			
			}
		});
		mnFile.add(mntmStudentInformation);
		
		JLabel lblStudentInformation = new JLabel("STUDENT INFORMATION");
		lblStudentInformation.setFont(new Font("Arial", Font.BOLD, 24));
		lblStudentInformation.setBounds(220, 60, 297, 31);
		contentPane.add(lblStudentInformation);
		
		table = new JTable();
		table.setBounds(42, 137, 648, 240);
		contentPane.add(table);
		
		JButton btnShowInformation = new JButton("Show Information");
		btnShowInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String sqlQuery = "SELECT * FROM studentTable";
					PreparedStatement statement = dbConnection.prepareStatement(sqlQuery);
					// add the result set
					ResultSet res = statement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(res));
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnShowInformation.setBounds(268, 409, 169, 29);
		contentPane.add(btnShowInformation);
	}
}
