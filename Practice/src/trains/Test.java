package trains;

//TODO all setters must be immutable
//TODO safety on all set/get
//TODO add :switch location

public class Test {

	public static void main(String[] args) {

		System.out.println("TRAIN SIMULATOR");
		
		// Init fault layer, communicate with JSON files
		faultLayer faultLayer = new faultLayer();
		faultLayer.setupTracks();
		faultLayer.setupSwitches();
		faultLayer.setupStations();
		System.out.println("\nJSON FILES LOADED");

		//Create Trains
		train train = new train("First Train", "S1-1", true, "S5-1");
		System.out.println("Train: First Train created");
		
		System.out.println("First Train : Plan path to station");
		train.planPath();
		//train.executePath();
		
	}
}
