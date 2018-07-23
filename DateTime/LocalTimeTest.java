package localTime;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class LocalTimeTest {
	public static void main(String[] args) {
		LocalTime time = LocalTime.now();
		System.out.println("time = " + time);
		System.out.println("MIN = " + time.MIN);
		System.out.println("MAX = " + time.MAX);
		System.out.println("MIDNIGHT = " + LocalTime.MIDNIGHT);
		System.out.println("NOON = " + LocalTime.NOON);
		
		System.out.println("time = " + time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		System.out.println("time = " + time.format(DateTimeFormatter.ofPattern("HH:mm:ss.n")));
		
		// Simulation Java-Schulung
		LocalTime startJava = LocalTime.of(8, 0);
		System.out.println("startJava = " + startJava);
		LocalTime erstePause = LocalTime.of(9, 30, 0);
		System.out.println("erstePause = " + erstePause);
		Duration dauerErsteBlock = Duration.between(startJava, erstePause);
		System.out.println("dauerErsteBlock = " + dauerErsteBlock);
		System.out.println("dauerErsteBlock in Minuten = " + dauerErsteBlock.toMinutes());
		Duration dauerErstePause = Duration.ofMinutes(15);
		LocalTime endeErstePause = erstePause.plus(dauerErstePause);
		System.out.println("endeErstePause = " + endeErstePause);
		LocalTime zweitePause = LocalTime.parse("11:15:00");
		System.out.println("zweitePause = " + zweitePause);
		LocalTime endeZweitePause = zweitePause.plusMinutes(15);
		System.out.println("endeZweitePause = " + endeZweitePause);
		Duration dauerDritteBlock = Duration.ofHours(1).plusMinutes(30);
//		dauerDritteBlock = Duration.ofHours(1).withSeconds(30*60);
//		dauerDritteBlock = Duration.parse("PT1H30M");
		LocalTime mittagsPause = endeZweitePause.plus(dauerDritteBlock);
		System.out.println("mittagsPause = " + mittagsPause);
	}
}
