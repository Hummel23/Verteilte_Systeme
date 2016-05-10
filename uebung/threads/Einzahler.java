package uebung.threads;

public class Einzahler extends Thread{
	private Konto konto;
	
	public Einzahler(Konto k){
		this.konto = k;
	}
	
	public void run(){
		int betrag;
		for (int i = 0; i < 10; i++) {
			betrag = (int)(Math.random()*1000);
			konto.einzahlung(betrag);
			System.out.println("Einzahler " + betrag + " Stand: " + konto.stand());
			try{
				sleep(2000);
			}catch (InterruptedException e){
				
			}
		}
	}
}
