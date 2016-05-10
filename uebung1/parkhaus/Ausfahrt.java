package uebung1.parkhaus;

/**
 * Klasse Ausfahrt, erbt von Thread
 * @author Saba Kues
 */
public class Ausfahrt extends Thread {

	/**
	 * Parkhaus
	 */
	private Parkhaus parkhaus;

	/**
	 * Konstruktor der Ausfahrt. Das zugehörige Parkhaus
	 * wird als Parameter mitgegeben.
	 * @param ph (Parkhaus)
	 */
	public Ausfahrt (Parkhaus ph){
		this.parkhaus=ph;
	}

	/*
	 * Lässt Autos im zufälligen Sekundenabstand aus dem Parkhaus fahren.
	 * @see java.lang.Thread#run()
	 * @throws InterruptException falls sleep des Threads unterbrochen wird
	 */
	public void run(){
		while (true) {
			this.parkhaus.ausfahren();
			try {
				sleep((int)(Math.random()*2000));
			} catch (InterruptedException e) {
				Logger.getInstance().info("[Ausfahrt.java] run: sleep unterbrochen");
			} 
		}
	}
}
