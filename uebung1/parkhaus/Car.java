package uebung1.parkhaus;

/**
 * Class car represents a car. It extends Thread. 
 * 
 * @author Saba Kues
 *
 */
public class Car extends Thread{
	
	/**
	 * Class variable parking lot, defines the parking that the car will enter/exit.
	 */
	private Parkinglot parkinglot;
	
	
	/**
	 * Class variable identification, clearly identifies a car.
	 */
	public int identification;
	
	
	/**
	 * Constructor for the car. 
	 * @param pl (Parkinglot)
	 * @param id (int)
	 */
	public Car(Parkinglot pl, int id){
		this.parkinglot=pl;
		this.identification=id;
		this.start();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		
		try {
			sleep((int) (Math.random()*1000));
		} catch (InterruptedException e) {
			Logger.getInstance().error("[Auto.java]: sleep before entry failed");
		}
		
		this.parkinglot.enter(this);
		
		try {
			sleep((int) (Math.random()*1000));
		} catch (InterruptedException e) {
			Logger.getInstance().error("[Auto.java]: sleep before exit failed");
		}
		
		this.parkinglot.exit(this);
	}
}
