
public class Trains implements Runnable {
	
	public int id;
	public int frontLocation;
	public int backLocation;
	public boolean heartbeat;
	public int speed;
	
	
	public Trains(int startFrontLocation, int startBackLocation, int startSpeed) {
		
		frontLocation = startFrontLocation;
		backLocation = startBackLocation;
		speed = startSpeed;
		
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
	
	public void speedUp(int increment) {
		speed += increment;
	}
	
	Thread newTrain;
	
	Trains() {
		
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
