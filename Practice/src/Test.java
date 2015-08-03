
public class Test {

	public static void main(String[] args) {
		
		Tracks tracks = new Tracks(10, 10);
		
		train train = new train("First Train", 5, 5, true, 0);
		tracks.addTrain(train);
		
		Routine routine = new Repeat((new RandomRoute(tracks)));
		train.setRoutine(routine);
		System.out.println(train);
		
		
		for (int i = 0; i < 5; i++) {
			train.update();
			System.out.println(train);
		}
	}
}
