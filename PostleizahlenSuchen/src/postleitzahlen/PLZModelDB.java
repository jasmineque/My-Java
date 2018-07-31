package postleitzahlen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PLZModelDB implements PLZModelInterface{

	String accessConnect = "jdbc:ucanaccess://PLZ_Datenbank.accdb";
	Connection verbindung;
	Statement befehl;
	ResultSet ergebnismenge;
	
	public PLZModelDB() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); // Treiberklasse für Access wird geladen
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			verbindung = DriverManager.getConnection(accessConnect);
			System.out.println("Verbindung erfolgreich");
			befehl = verbindung.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String sucheOrt(int plz) {
		try {
			ergebnismenge = befehl.executeQuery("select Ort from tblPLZ where plz = " + plz);
			if (ergebnismenge.next()) {
				return ergebnismenge.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String sucheBundesland(int plz) {
		try {
			ergebnismenge = befehl.executeQuery("select Bundesland from tblPLZ where plz = " + plz);
			if (ergebnismenge.next()) {
				return ergebnismenge.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
