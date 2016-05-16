package uebung1.parkhaus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents the parking lot. 
 * 
 * @author Saba Kues
 */

public class Parkinglot{

	/**
	 * capacity/free parking spots in the parking lot.
	 */
	private int capacity;

	/**
	 * saves the cars that enter/want to enter the parking lot in a queue. 
	 */
	private Queue<Car> queue = new LinkedList<>();
	//TODO check use of concurrentlinkedqueue
	
	/**
	 * logs information/errors and displays them in the console.
	 */
	private Logger logger = Logger.getInstance();

	/**
	 * Creates the parking lot with the capacity defined in the parameter.
	 * @param cap (int)
	 */
	public Parkinglot(int cap){
		if(cap<0){
			cap=0;
		}
		this.capacity=cap;
	}

	/**
	 * A car is added to the queue for entering the parking lot. If the parking lot still has
	 * capacity it is removed from the queue immediately and the capacity is decreased by 1.
	 * Otherwise the car will wait for notification that there is capacity. When capacity is available 
	 * again the first car in the queue will enter the parking lot.  
	 * @param car (Car)
	 */
	public synchronized void enter(Car car) {

		logger.info("car-id " + car.identification + ": arrived");
//		if (capacity == 0){
//			try {	
//				queue.add(car);
//				logger.info("car-id " + car.identification + ": waits - parking lot full");
//				do{
//					wait();
//				}while(!queue.element().equals(car)|| capacity==0);
//				queue.poll();
//			} catch (InterruptedException e) {
//				logger.error("[Parkhaus.java] [car-id: " + car.identification +"] enter(): fails");
//			}
//		}
		queue.add(car);
		while(capacity==0 || !queue.element().equals(car)){
			try{
				logger.info("car-id " + car.identification + ": waits - parking lot full");
				wait();
			}catch (InterruptedException e){
				logger.error("[Parkhaus.java] [car-id: " + car.identification +"] enter(): fails");
			}
		}
		queue.poll();
		capacity--;
		logger.info("car-id " + car.identification + ": entered");
		logger.info("capacity: " + capacity);
	}

	/**
	 * A car will exit the parking lot. Capacity will be incremented. Other Threads will be notified. 
	 * @param car (Car)
	 */
	public synchronized void exit(Car car) {
		capacity++;
		logger.info("car-id " + car.identification + ": left");
		logger.info("capacity: " + capacity);
		notifyAll();
	}
}
