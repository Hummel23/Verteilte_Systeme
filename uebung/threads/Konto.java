package uebung.threads;

public class Konto {
	
	private int einz, ausz, stand;
	private boolean zugriff=false;
	
	synchronized
	public int auszahlung(){
		while(!zugriff){
			try{
				wait();
			}catch (InterruptedException e){
				
			}
		}
		this.ausz = this.einz;
		this.stand -= this.ausz;
		zugriff = false;
		notifyAll();
		return this.ausz;
	}
	
	synchronized
	public void einzahlung(int wert){
		while(zugriff){
			try{
				wait();
			}catch (InterruptedException e){
				
			}
		}
		this.einz = wert;
		this.stand += this.einz;
		zugriff = true;
		notifyAll();
	}
	
	public int stand(){
		return this.stand;
	}
}
