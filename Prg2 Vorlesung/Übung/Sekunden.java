/*
 * Created on 	12.03.2010 / 2016
 * @author  	Breunig / Mühlbauer
 * Zweck:		Einfaches Programm mit Ein-/Ausgabe (wie bei C)
 */

import java.util.Scanner;

public class Sekunden {
	private final static int SEKUNDEN_PRO_MINUTE = 60;
	private final static int MINUTEN_PRO_STUNDE = 60;

	// "throws" und Exceptions werden sp#ter in der Vorlesung behandelt
	public static void main(String[] args)
//		throws NumberFormatException, IOException
	{
		
		int sekunden, minuten, stunden;

		// Eingabe mit SCanner
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bitte Stunden eingeben: ");
		stunden = scanner.nextInt();
		System.out.println("Bitte Minuten eingeben: ");
		minuten = scanner.nextInt();
		
		// Sekunden berechnen
		sekunden = ((stunden * MINUTEN_PRO_STUNDE) + minuten) * SEKUNDEN_PRO_MINUTE;
		
		// und ausgeben
		System.out.println(stunden + " Stunden und " + minuten + " Minuten sind " + sekunden + " Sekunden.");
	}
}
