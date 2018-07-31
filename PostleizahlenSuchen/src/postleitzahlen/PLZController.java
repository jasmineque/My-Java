package postleitzahlen;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class PLZController {
	
	PLZModelInterface model;
	PLZViewInterface view;
	
	public PLZController(PLZViewInterface view) {
		this.view = view;
//		this.model = new PLZModel();
		this.model = new PLZModelDB();
	}
	
	public void suchen() {
		int plz = view.getPLZ(); // PLZ aus View
		String ort = model.sucheOrt(plz); // Mit der PLZ aus View Ort aus Model abfragen
		view.setOrt(ort); // Ergebnis (Ort) in View schreiben
		String bundesland = model.sucheBundesland(plz); // Mit der PLZ aus View Bundealand aus Model abfragen
		view.setBundesland(bundesland);
	}
	
	public void beenden() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Beenden");
		alert.setContentText("Wollen Sie wirklich beenden?");
		ButtonType buttonYes = new ButtonType("Ja", ButtonData.OK_DONE);
		ButtonType buttonNo = new ButtonType("Nein", ButtonData.CANCEL_CLOSE);
		alert.getButtonTypes().setAll(buttonYes, buttonNo);
		alert.showAndWait();
		System.out.println(alert.getResult());
		if (alert.getResult() == buttonYes) {
			System.exit(0);
		}
	}
	
	public void loeschen() {
		view.setPLZ("");
		view.setOrt("");
		view.setBundesland("");
	}

	public void info() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText("© 2018 Comcave MH");
		alert.setContentText("PLZ-Suche");
		alert.show();
	}

}





