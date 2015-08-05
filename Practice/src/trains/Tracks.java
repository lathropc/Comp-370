package trains;

public class Tracks {

	public void executePath() {

		System.out.println("\nTrain in motion!\n\nStarting Track S1-1\nDestination S5-1");
		try {
		    Thread.sleep(3000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("Train about to hit Track S2-1\nVerifying conditions:");
		System.out.println("Track S2-1: Live\nTrain: First Train: Live\nSwitch: no switch\nSuccess");
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("\nTrain: First Train is on Track: S2-1");

		try {
		    Thread.sleep(3000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("Train about to hit Track S1-3\nVerifying conditions:");
		System.out.println("Track S3-1: Live\nTrain: First Train: Live\nSwitch: no switch\nSuccess");
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("\nTrain: First Train is on Track: S3-1");
		try {
		    Thread.sleep(3000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("Train about to hit Track S4-1\nVerifying conditions:");
		System.out.println("Track S4-1: Live\nTrain: First Train: Live\nSwitch: no switch\nSuccess");
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("\nTrain: First Train is on Track: S4-1");
		try {
		    Thread.sleep(3000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("Train about to hit Track S5-1\nVerifying conditions:");
		System.out.println("Track S5-1: Live\nTrain: First Train: Live\nSwitch: no switch\nStation: Live\nSuccess");
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("\nTrain: First Train is on Track: S5-1");
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("\nTrain: First Train is at Destination:\nTrack: S5-1\nStation: Alewife");

	}
	
	
}
