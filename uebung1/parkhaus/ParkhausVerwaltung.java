package uebung1.parkhaus;

/**
 * Klasse ParkhausVerwaltung
 * 
 * Erstellt das Parkhaus, eine Einfahrt und eine Ausfahrt.
 * Startet den Prozess des ein- und ausfahrens.
 * @author Saba Kues

 */
public class ParkhausVerwaltung {

	public static void main(String[] args) {
		Parkhaus parkhaus = new Parkhaus();
		Einfahrt einfahrt = new Einfahrt(parkhaus);
		Ausfahrt ausfahrt = new Ausfahrt(parkhaus);

		einfahrt.start();
		ausfahrt.start();

	}

}
