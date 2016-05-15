package uebung1.parkhaus;

/**
 * Contains main-method to instantiate the parking lot and the cars. 
 * 
 * @author Saba Kues
 */
public class ParkinglotMain {

	/**
	 * Creates a parking lot and an array with 15 cars, that enter and exit the parking lot. 
	 */
	public static void main(String[] args) {
		Parkinglot parkinglot = new Parkinglot(10);
		Car cars[] = new Car[25];
		
		for (int i = 0; i < cars.length; i++) {
			cars[i]=new Car(parkinglot, i+1);
		}

	}

}
