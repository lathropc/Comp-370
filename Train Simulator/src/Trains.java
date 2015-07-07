
public class Trains implements Runnable {
	
	public int id;
	public int frontLocation;
	public int backLocation;
	public boolean heartbeat;
	public int speed;
	
	
	public Trains(int id, int frontLocation, int backLocation, int speed) {
		
		id = this.id;
		frontLocation = this.frontLocation;
		backLocation = this.backLocation;
		speed = this.speed;
		
	}
	
	public void setFrontLocation(int newValue) {
		frontLocation = newValue;
	}
	
	public void setBackLocation(int newValue) {
		backLocation = newValue;
	}
	
	public void applyBreak(int decrement) {
		speed -= decrement;
	}
	
	/*
	 * Method for stop, loop with the applyBrake method to simulate a stop.
	 */
	
	public void speedUp(int increment) {
		speed += increment;
	}
	
	Thread newTrain;
	
	Trains() {
		
		//Include logic to check present train id's and assign id's to new train 
		newTrain = new Thread(this, "A new train");
		System.out.println("New train created" + newTrain);
		newTrain.start();
		
	}

	@Override
	public void run() {
		try {
			for(int i=0; i<10; i++) {
				
				System.out.println("Printing count" + i);
				Thread.sleep(1000);
				
			}
		}
		
		catch(InterruptedException e) {
			
			System.out.println("My Train interrupted");
			
		}
		
		System.out.println("newTrain run is over");
		
	}
}

class testTrains {
	
	public static void main(String args[]) {
		
		//Basic thread testing to make sure they work. 
		Trains train1 = new Trains();
		
		try {
			while(train1.newTrain.isAlive())
			{
				System.out.println("Main thread will be alive until the child thread dies");
				
				Thread.sleep(1500);
			}
		}
		
		catch(InterruptedException e) {
			
			System.out.println("Main thread interrupted");
			
		}
		
		System.out.println("Main thread run is over");
	}
}
