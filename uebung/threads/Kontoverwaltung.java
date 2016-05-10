package uebung.threads;

public class Kontoverwaltung {

	public static void main(String[] args) {
		Konto konto = new Konto();
		Einzahler ez = new Einzahler(konto);
		Abholer ah = new Abholer(konto);
		ez.start();
		ah.start();
	}

}
