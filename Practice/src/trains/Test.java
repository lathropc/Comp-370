package trains;
public class Test {

	public static void main(String[] args) {

		Tracks tracks = new Tracks(10, 10);

		train train = new train("First Train", "S1-1", true, 0);
		tracks.addTrain(train);

		Routine routine = new Repeat(tracks);
		train.setRoutine(routine);
		System.out.println(train);

		for (int i = 0; i < 5; i++) {
			train.update(); 
			System.out.println(train);
		}
	}
}
