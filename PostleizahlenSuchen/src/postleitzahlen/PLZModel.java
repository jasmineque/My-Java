package postleitzahlen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PLZModel implements PLZModelInterface {

	@Override
	public String sucheOrt(int plz) {
		InputStream is = getClass().getResourceAsStream("plz.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String zeile;
		try {
			while ((zeile = br.readLine()) != null) {
				
//				1. Nur die Zeile ausgeben, die die PLZ enthält
//				if (zeile.startsWith(String.valueOf(plz))) {
//					System.out.println(zeile);
//				}
//				2. Diese Zeile returnen
//				if (zeile.startsWith(String.format("%05d", plz))) { //1069 => 01069
//					return zeile;
//				}
//				3. Den Ort aus der Zeile extrahieren und returnen
//				if (zeile.startsWith(String.format("%05d", plz)) || zeile.indexOf(String.format("%05d", plz)) == 1) { //1069 => 01069
//				if (zeile.replace('\uFEFF',' ').trim().startsWith(String.format("%05d", plz))) {
//					String sub = zeile.substring(6).trim();
//					return sub.substring(0, sub.indexOf("\t"));
//				}
				// Tipp: split
				String[] plzArr = zeile.split("\\t");
				if (plzArr[0].trim().contains(String.format("%05d", plz))) {
					return plzArr[1].trim();
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			return Files.lines(Paths.get("plz.txt")).
//					filter(zeile -> zeile.startsWith(String.format("%05d", plz))).
//					map(zeile -> zeile.split("\\t")[1]).
//					reduce((s1, s2) -> s1 + ", " + s2).orElse(null);

		return "";
	}

	@Override
	public String sucheBundesland(int plz) {
		try {
			Scanner sc = new Scanner(new File("plz.txt"));
			while(sc.hasNextLine()) {
				String zeile = sc.nextLine();
				String[] plzArr = zeile.split("\\t");
				if (plzArr[0].trim().contains(String.format("%05d", plz))) {
					return plzArr[5].trim();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
