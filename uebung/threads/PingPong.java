package uebung.threads;

public class PingPong extends Thread{
	
	String zeichenkette;
	int verzoegerung;
	
	PingPong(String wassagen, int wielange){
		this.zeichenkette = wassagen;
		this.verzoegerung = wielange;
	}
	
	public void run(){
		try{
			for(;;){
				System.out.println(this.zeichenkette + " ");
				sleep(this.verzoegerung);
			}
		}catch(InterruptedException e){
			return;
		}
	}
	public static void main(String[] args) {
		new PingPong("ping", 33).start();
		new PingPong("PONG", 100).start();

	}

}
