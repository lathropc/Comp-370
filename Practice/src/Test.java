
public class Test {

	public static void main(String[] args) {
		//Setup
		Tracks tracks = new Tracks(10, 10);
		
		train train = new train(1, 5, 5, true, 0);
		tracks.addTrain(train);
		
		Routine moveTo = new MoveTo(7, 9);
		train.setRoutine(moveTo);
		System.out.println(train);
		
		//Execute 5 moves and print train out
		for (int i = 0; i < 5; i++) {
			train.update();
			System.out.println(train);
		}
	}
}
