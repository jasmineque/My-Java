import java.sql.*;
import javax.swing.*;

public class DatabaseConnection {
	
	Connection dbConnection = null;
	
	public static Connection dataConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection dbConnection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Que\\eclipse-workspace\\DatabaseTest\\database\\my_database.sqlite");
			JOptionPane.showMessageDialog(null, "Database connection established with the database");
			return dbConnection;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return null;
		}
	}

}
