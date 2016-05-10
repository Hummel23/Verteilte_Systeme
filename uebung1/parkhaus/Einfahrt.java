package uebung1.parkhaus;

/**
 * Klasse Einfahrt, erbt von Thread.
 * @author Saba Kues
 */
public class Einfahrt extends Thread {

	/**
	 * Parkhaus
	 */
	private Parkhaus parkhaus;

	/**
	 * Konstruktor der Einfahrt. Das zugehörige Parkhaus
	 * wird als Parameter mitgegeben.
	 * @param ph (Parkhaus)
	 * 
	
	 */
	public Einfahrt (Parkhaus ph){
		this.parkhaus=ph;
	}


	/* 
	 * Lässt Autos im zufällig generierten Sekundenabstand ins Parkhaus einfahren. 
	 * @see java.lang.Thread#run()
	 * @throws InterruptException falls sleep des Threads unterbrochen wird
	 */
	public void run(){
		while (true) {
			this.parkhaus.einfahren();
			try {
				sleep((int)(Math.random()*2000));
			} catch (InterruptedException e) {
				Logger.getInstance().info("[Einfahrt.java] run: sleep unterbrochen");
			}

		}
	}

}
