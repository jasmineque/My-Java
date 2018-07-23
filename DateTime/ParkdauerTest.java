package localTime;

import java.time.Duration;
import java.time.LocalTime;

public class ParkdauerTest {
	public static void main(String[] args) {
		LocalTime parkbeginn = LocalTime.of(7, 56);
		LocalTime parkende1 = LocalTime.of(11, 20);
		LocalTime parkende2 = LocalTime.of(13, 06);
		LocalTime parkende3 = LocalTime.of(15, 13);
		
		double parkgebuehr1 = 0;
		double parkgebuehr2 = 0;
		double parkgebuehr3 = 0;
		
		// Variante 1: Parkgebühr immer
		// Variante 2: Parkgebühr zwischen 9:00 und 20 Uhr
		// Variante 1: Immer 1 Euro pro Stunde
		// Variante 2: In den ersten drei Stunden 1 Euro pro Stunde, danach 1,50 pro Stunde
		// Jede angefangene Minute zählt
		
		long dauerPark1 = Duration.between(parkbeginn, parkende1).toMinutes();
		System.out.println("dauerPark1 = " + dauerPark1 + " Minuten");
		parkgebuehr1 = dauerPark1 * 100/60 / 100.00;
		System.out.println("parkgebuehr = " + parkgebuehr1 + " Euro ");
		
		long dauerPark2 = Duration.between(parkbeginn, parkende2).toMinutes();
		System.out.println("dauerPark2 = " + dauerPark2 + " Minuten");
		parkgebuehr2 = dauerPark2 * 100/60 / 100.00;
		System.out.println("parkgebuehr = " + parkgebuehr2 + " Euro ");
		
		long dauerPark3 = Duration.between(parkbeginn, parkende3).toMinutes();
		System.out.println("dauerPark3 = " + dauerPark3 + " Minuten");
		parkgebuehr3 = dauerPark3 * 100/60 / 100.00;
		System.out.println("parkgebuehr = " + parkgebuehr3 + " Euro ");
		
	}
}
