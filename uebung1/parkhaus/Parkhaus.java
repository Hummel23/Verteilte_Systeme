package uebung1.parkhaus;

/**
 * Diese Klasse repräsentiert ein Parkhaus.
 * @author Saba Kues
 */

public class Parkhaus {

	/**
	 * Anzahl der freien Plätze im Parkhaus, sollte nie größer als 10 und nie kleiner als 0 sein. 
	 */
	private int anzFreiePlaetze = 10;


	/**
	 * @return gibt aktuellen Wert der freien Plätze zurück. 
	 */
	public int getAnzFreiePlaetze() {
		return anzFreiePlaetze;
	}

	/**
	 * Synchronisierte Methode, die die Anzahl der freien Plätze herabzählt. Wenn
	 * es keine freien Plätze mehr gibt (anzFreiePlätze=0), wird auf die Nachricht gewartet,
	 * dass Platz frei geworden ist.
	 * Informiert alle weiteren Prozesse sobald die Anzahl der freien Plätze herabgesetzt wurde.
	 * @throws InterruptedException falls das Warten des Threads unterbrochen wird.
	 * 

	 */
	public synchronized void einfahren() {
		if(this.anzFreiePlaetze == 0){
			try{
				System.out.println("Keine Einfahrt möglich. Das Parkhaus ist voll. ");
				wait();
			}catch(InterruptedException e){
				Logger.getInstance().error("[Parkhaus.java] einfahren: wait unterbrochen");
			}
		}
		this.anzFreiePlaetze--;
		System.out.println("Einfahrt. Freie Parkplätze: " + getAnzFreiePlaetze());
		notifyAll();		
	}

	/**
	 * Synchronisierte Methode, die die Anzahl der freien Plätze erhöht. Wenn
	 * alle Plätze frei sind (anzFreiePlaetze=10) wird gewartet bis wieder Plätze belegt sind.
	 * Informiert alle weiteren Prozesse sobald die Anzahl der Autos heraufgesetzt wurde. 
	 * 
	 * @throws InterruptedException falls das Warten des Threads unterbrochen wird.
	 */
	public synchronized void ausfahren(){
		if(this.anzFreiePlaetze == 10){
			try{
				System.out.println("Keine Ausfahrt möglich. Das Parkhaus ist leer");
				wait();
			}catch(InterruptedException e){
				Logger.getInstance().error("[Parkhaus.java] ausfahren: wait unterbrochen");

			}
		}
		this.anzFreiePlaetze++;
		System.out.println("Ausfahrt. Freie Parkplätze: " + getAnzFreiePlaetze());
		notifyAll();
	}
}
