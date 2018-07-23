package localTime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeTest {

	public static void main(String[] args) {
		LocalDateTime jetzt = LocalDateTime.now();
		System.out.println("jetzt: " + jetzt);
		System.out.println("jetzt: " + jetzt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));
		
		// Letzter Freitag im Monat 12 Uhr mittags
		LocalDateTime erinnerung = jetzt.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY)).with(LocalTime.NOON);
		System.out.println("erinnerung = " + erinnerung);
		
		// Flug ab Düsseldorf nach Kapstadt, Start: 20.07.2018 18:15 Uhr
		// Zwischenhalt in Zürich, Flugdauer 1 Stunde 20 Minuten
		// Aufenthalt in Zürich: 2 Stunden 15 Minuten
		// Flugdauer von Zürich nach Kapstadt 9 Stunden 40 Minuten
		// Ankunft in Kaptstadt?
		
		LocalDateTime beginn = LocalDateTime.of(2018, 7, 20, 18, 15);
		Duration flugdauer1 = Duration.ofHours(1).plusMinutes(20);
		Duration dauer1 = Duration.ofHours(2).plusMinutes(15);
		Duration flugdauer2 = Duration.ofHours(9).plusMinutes(40);
		LocalDateTime ankunft = beginn.plus(flugdauer1).plus(dauer1).plus(flugdauer2);
		System.out.println("ankunft: " + ankunft.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));
		Duration dauerTotal = flugdauer1.plus(dauer1).plus(dauer1).plus(flugdauer2);
		System.out.println("dauerTotal = " + dauerTotal);
		
		
	}

}
