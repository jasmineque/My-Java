package localTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class PeriodTest {

	public static void main(String[] args) {
		
		// Java 11 gibt es heute in einem Jahr, fünf Monaten und 13 Tagem
		Period p = Period.ofYears(1).withMonths(5).withDays(13);
		System.out.println("p = " + p);
		LocalDate java11Release = LocalDate.now().plus(p);
		System.out.println("java11Release = " + java11Release.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
		
		// Wie viele Tage sind Sie auf der Welt?
		LocalDate geburtstag = LocalDate.of(1984, 1, 9);
		Period p1 = Period.between(geburtstag, LocalDate.now());
		System.out.println(p1);
		long p2 = ChronoUnit.DAYS.between(geburtstag, LocalDate.now());
		System.out.println(p2 + " Tagen");
		long p3 = TimeUnit.DAYS.toSeconds(p2);
		System.out.printf("%,d Sekunden", p3);
		System.out.println();
		
		LocalDateTime geburtsdatum = LocalDateTime.of(1966, 10, 13, 12, 30);
		System.out.println(geburtsdatum.until(LocalDateTime.now(), ChronoUnit.SECONDS));
	}

}
