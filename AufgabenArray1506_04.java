//import java.util.Arrays;
import java.util.Scanner;

public class AufgabenArray1506_04 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double[] numArray = new double[100_000];
		int count = 0;
		
		System.out.println("Bitte geben Sie eine Zahl zwischen 0 und 50.000 (mit zwei Dezimalstellen) ein: ");
		float num = sc.nextFloat();
		
		while (num < 0 || num > 50_000) {
			System.out.println("Die Zahl ist ungültig! Bitte geben Sie eine andere Zahl ein: ");
			num = sc.nextFloat();
		}
		
		for (int i = 0; i < 100_000; i++) {
			double numRand = randomNumber(49_999,0);
			numArray[i] = numRand;
		}
//		System.out.println("numArray: " + Arrays.toString(numArray));
		
		OUTER: for (int j = 0; j <= 100_000; j++) {
			
			if (j == 100_000) {
				System.out.println("Ende des Arrays!");
				break;
			}
			
			if (Math.abs(numArray[j] - num) < 1) {
				count++;
				System.out.println("Die Zahle " + numArray[j] + " wird an der " + j + ". " + 
			                       "Stelle gefunden. Möchten Sie nach weiteren Vorkommen suchen? (j/n)");
				String answer = sc.next();
				System.out.println("answer = " + answer);
				if (answer.equals("j") || answer.equals("J") ) {
					continue;
				} else {
					System.out.println("Sie möchten nicht mehr suchen!");
					break OUTER;
				}
			}
		}
		System.out.println("Die Zahle " + num + " wird " + count + " mal in dem Array gefunden.");
		
		sc.close();
	}
	
	public static double randomNumber(int max, int min) {
		double numRand = Math.random()*((max-min)+1) + min;
		return Math.round(numRand*100.0)/100.0;
	}
	
}
