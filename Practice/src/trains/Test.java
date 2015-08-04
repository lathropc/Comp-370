package trains;

//TODO all setters must be immutable
//TODO safety on all set/get
//TODO add :switch location

public class Test {

	public static void main(String[] args) {

		Tracks tracks = new Tracks(10, 10);

		train train = new train("First Train", "S1-1", true, 0);
		tracks.addTrain(train);
		
		faultLayer faultLayer = new faultLayer();
		faultLayer.setupTracks();
		faultLayer.setupSwitches();
		faultLayer.setupStations();
		
	}
}
