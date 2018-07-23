package localTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ZonedDateTimeTest {

	public static void main(String[] args) {
		LocalDateTime nowInNY = LocalDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("nowInNY = " + nowInNY);
		ZonedDateTime nowInLA = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("nowInLA = " + nowInLA.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		System.out.println("nowInLA = " + nowInLA.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println("nowInLA = " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
		ZonedDateTime nowInSydney = now.withZoneSameInstant(ZoneId.of("Australia/Sydney"));
		System.out.println("nowInSydney = " + nowInSydney.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
		
		ZoneId.getAvailableZoneIds().stream().sorted().forEach(System.out::println);
		
		// Flug nach Auckland
		// Abflug ab Frankfurt heute um 16:50 Uhr Ortszeit
		// Flugdauer nach Dubai 6 Stunden 20 Minuten
		// Aufenthal Dubai 3 Stunden 35 Minuten
		// Flugdauer nach Auckland 17 Stunden 15 Minuten
		// Flugplan mit Datum und Ortszeiten
		ZonedDateTime abflug = ZonedDateTime.of(LocalDateTime.of(2018, 7, 20, 16, 50), ZoneId.of("Europe/Berlin"));
		Duration flugdauer1 = Duration.ofHours(6).plusMinutes(20);
		ZonedDateTime ankunftDuBai = abflug.plus(flugdauer1).withZoneSameInstant(ZoneId.of("Asia/Dubai"));
		Duration dubaiDauer = Duration.ofHours(3).plusMinutes(35);
		ZonedDateTime abflugDuBai = abflug.plus(flugdauer1).plus(dubaiDauer).withZoneSameInstant(ZoneId.of("Asia/Dubai"));
		Duration flugdauer2 = Duration.ofHours(17).plusMinutes(15);
		ZonedDateTime ankunft = abflug.plus(flugdauer1).plus(dubaiDauer).plus(flugdauer2).withZoneSameInstant(ZoneId.of("Pacific/Auckland"));
		
		System.out.println("abflugFrankfurt: " + abflug.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		System.out.println("ankunftDubai: " + ankunftDuBai.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		System.out.println("abflugDubai: " + abflugDuBai.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		System.out.println("ankunftAuckland: " + ankunft.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
	}

}
