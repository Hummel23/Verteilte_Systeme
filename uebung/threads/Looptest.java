package uebung.threads;

public class Looptest extends Thread{
	private String myName;
	
	public Looptest(String name){
		this.myName=name;
	}
	
	public void run(){
		for (int i = 1; i <= 100; i++) {
			System.out.println(myName + " (" + i + ")");
			try{
				sleep(1000);
			}catch (InterruptedException e){
				
			}
		}
	}

	public static void main(String[] args) {
		Looptest t1 = new Looptest("Thread 1");
		Looptest t2 = new Looptest("Thread 2");
		Looptest t3 = new Looptest("Thread 3");
		t1.start();
		t2.start();
		t3.start();

	}

}
