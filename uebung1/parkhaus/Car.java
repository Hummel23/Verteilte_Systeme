package uebung1.parkhaus;

public class Car extends Thread{
	
	private Parkinglot parkinglot;
	public int identification;
	
	public Car(Parkinglot pl, int id){
		this.parkinglot=pl;
		this.identification=id;
		this.start();
	}
	
	public void run() {
		
		try {
			sleep((int) (Math.random()*1000));
		} catch (InterruptedException e) {
			Logger.getInstance().error("[Auto.java]: warten auf ausfahren fehlgeschlagen");
		}
		
		this.parkinglot.enter(this);
		
		try {
			sleep((int) (Math.random()*1000));
		} catch (InterruptedException e) {
			Logger.getInstance().error("[Auto.java]: warten auf ausfahren fehlgeschlagen");
		}
		
		this.parkinglot.exit(this);
	}
}
