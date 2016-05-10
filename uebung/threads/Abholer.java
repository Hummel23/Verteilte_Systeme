package uebung.threads;

public class Abholer extends Thread{
	
	private Konto konto;
	
	public Abholer(Konto k){
		this.konto=k;
		
	}
	
	public void run(){
		int wert;
		for (int i = 0; i < 10; i++) {
			wert=konto.auszahlung();
			System.out.println("Abholer " + wert + " Stand: " + konto.stand());
			try{
				sleep(2000);
			}catch (InterruptedException e){
				
			}
		}
	}
}
