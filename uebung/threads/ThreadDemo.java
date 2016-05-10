package uebung.threads;

public class ThreadDemo extends Thread {
	char c;

	public static void main(String[] args) {
		ThreadDemo t1 = new ThreadDemo('x');
		ThreadDemo t2 = new ThreadDemo('u');
		t1.start();
		t2.start();
	}
	
	public ThreadDemo(char c){
		this.c = c;
	}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			Ausgabe.schreibeInZeile(c);
		}
	}

}

class Ausgabe{
	synchronized
	static void schreibeInZeile(char c){
		for (int i = 0; i < 10; i++) {
			System.out.print(c + " ");
			
			// Code nur um die Ausführung zu verlangsamen
			int n=0;
			double w;
			while(n<1000){
				w=Math.sqrt(n++);
			}
		}
		System.out.println();
	}
}
