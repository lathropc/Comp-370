package trains;

//TODO all setters must be immutable
//TODO safety on all set/get
//TODO add :switch location

public class Test {

	public static void main(String[] args) {
		 System.out.println("INIT FAULT LAYER");
		faultLayer faultLayer = new faultLayer();
		 System.out.println("OK");

		faultLayer.setupTracks();
		faultLayer.setupSwitches();
		faultLayer.setupStations();
	}
}
