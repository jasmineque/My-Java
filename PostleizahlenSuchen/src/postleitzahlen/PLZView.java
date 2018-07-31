package postleitzahlen;

import java.awt.Toolkit;
import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PLZView extends Application implements PLZViewInterface {

	Label lblTitel;
	Label lblPLZ;
	Label lblOrt;
	Label lblBundesland;
	TextField txfPLZ;
	TextField txfOrt;
	TextField txfBundesland;
	Button btnSuchen;
	Button btnLoeschen;
	Button btnBeenden;
	MenuBar bar;
	Menu mnuDatei;
	Menu mnuInfo;
	MenuItem mniSuchen;
	MenuItem mniLoeschen;
	MenuItem mniBeenden;
	MenuItem mniInfo;
	BorderPane border;
	GridPane pane;
	GridPane buttonPane;
	Image imgLogo;
	ImageView imvLogo;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Initialisierung der Komponenten
		lblTitel = new Label("Postleitzahlensuche");
		lblPLZ = new Label("Postleitzahl");
		lblOrt = new Label("Ort");
		lblBundesland = new Label("Bundesland");
		txfPLZ = new TextField();
		txfOrt = new TextField();
		txfBundesland = new TextField();
		btnSuchen = new Button("Suchen");
		btnLoeschen = new Button("Löschen");
		btnBeenden = new Button("Beenden");
		bar = new MenuBar();
		mnuDatei = new Menu("Datei");
		mnuInfo = new Menu("Info");
		mniSuchen = new MenuItem("Suchen");
		mniLoeschen = new MenuItem("Löschen");
		mniBeenden = new MenuItem("Beenden");
		mniInfo = new MenuItem("Info");	
		imgLogo = new Image("file:C:\\Users\\Que\\eclipse-workspace\\PostleizahlenSuchen\\img\\PLZ.png");
		imvLogo = new ImageView(imgLogo);
		imvLogo.setFitWidth(87);
		imvLogo.setFitHeight(60);
		// Controller definieren
		PLZController controller = new PLZController(this);
		// Aktionen
		btnSuchen.setOnAction(event -> controller.suchen());
		btnLoeschen.setOnAction(event -> controller.loeschen());
		btnBeenden.setOnAction(event -> controller.beenden());
		mniSuchen.setOnAction(event -> controller.suchen());
		mniLoeschen.setOnAction(event -> controller.loeschen());
		mniBeenden.setOnAction(event -> controller.beenden());
		mniInfo.setOnAction(event -> controller.info());
		txfPLZ.setOnKeyReleased(event -> {
			if (txfPLZ.getText().length() == 5) {
				controller.suchen();
			}
		});

		// Layout
		border = new BorderPane();
		pane = new GridPane();
		buttonPane = new GridPane();
		pane.setVgap(30);
		pane.setHgap(30);
		pane.setPadding(new Insets(20));

		pane.add(lblTitel, 0, 0);
		pane.add(imvLogo, 1, 0);
		pane.add(lblPLZ, 0, 1);
		pane.add(txfPLZ, 1, 1, 2, 1);
		pane.add(lblOrt, 0, 2);
		pane.add(txfOrt, 1, 2, 2, 1);
		pane.add(lblBundesland, 0, 3);
		pane.add(txfBundesland, 1, 3, 2, 1);
		buttonPane.add(btnSuchen, 0, 0);
		buttonPane.add(btnLoeschen, 1, 0);
		buttonPane.add(btnBeenden, 2, 0);
		buttonPane.setPadding(new Insets(30));
		buttonPane.setHgap(90);
		buttonPane.setHgap(50);

		border.setTop(bar);
		border.setCenter(pane);
		border.setBottom(buttonPane);
		
		bar.getMenus().addAll(mnuDatei, mnuInfo);
		mnuDatei.getItems().addAll(mniSuchen, mniLoeschen, mniBeenden);
		mnuInfo.getItems().addAll(mniInfo);

		Scene scene = new Scene(border, 350, 380);
		primaryStage.setTitle("Postleitzahlensuche"); // Titelleiste
		lblTitel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

		primaryStage.setScene(scene); // Scene in Stage setzen
		primaryStage.centerOnScreen(); // Fenster zentrieren
		primaryStage.show(); // Sichtbarkeit

	}

	@Override
	public int getPLZ() {
		if (txfPLZ.getText().length() != 5) {
			throw new IllegalArgumentException("PLZ muss genau 5 Stellen haben: " + txfPLZ.getText());
		}
		return Integer.parseInt(txfPLZ.getText());
	}

	@Override
	public void setOrt(String ort) {
		txfOrt.setText(ort);
	}

	@Override
	public void setBundesland(String bundesland) {
		txfBundesland.setText(bundesland);		
	}

	@Override
	public void setPLZ(String plz) {
		txfPLZ.setText(plz);		
	}

}
