package uebung1.parkhaus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents the parking lot. 
 * 
 * @author Saba Kues
 */

public class Parkinglot {
	
	/**
	 * capacity/free parking spots in the parking lot.
	 */
	private int capacity;
	/**
	 * saves the cars that enter/want to enter the parking lot in a queue (Fifo)
	 */
	private Queue<Car> queue;
		
	/**
	 * loggs information/errors and displays them in the console.
	 */
	private Logger logger = Logger.getInstance();
	
	/**
	 * Creates the parking lot with the capacity defined in the parameter.
	 * @param cap
	 */
	public Parkinglot(int cap){
		if(cap<0){
			cap=0;
		}
		this.capacity=cap;
		queue = new LinkedList<>();
	}
	
	/**
	 * A car enters the parking lot by being added to the queue.
	 * If the parking lot still has capacity it is added immediately, otherwise it will wait for 
	 * notification that there is capacity. 
	 * @param car
	 */
	public synchronized void enter(Car car) {
		
		logger.info("car-id " + car.identification + ": arrived");
		
		while (capacity == 0){
			try {
				synchronized (queue) {
					queue.add(car);
					logger.info("car-id " + car.identification + ": waits - parking lot full");
					queue.wait();
				}
				
			} catch (InterruptedException e) {
				logger.error("[Parkhaus.java] [car-id: " + car.identification +"] enter(): fails");
			}
		}
		capacity--;
		logger.info("car-id " + car.identification + ": entered");
		logger.info("capacity: " + capacity);
	}

	/**
	 * A car will exit the parking lot by being removed from the queue. Other Threads will be notified. 
	 * @param car
	 */
	public synchronized void exit(Car car) {
		capacity++;
		logger.info("car-id " + car.identification + ": left");
		logger.info("capacity: " + capacity);
		notifyAll();
	}
}
