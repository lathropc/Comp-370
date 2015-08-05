package trains;

//TODO all setters must be immutable
//TODO safety on all set/get
//TODO add :switch location

public class Test {

	public static void main(String[] args) {


		
		train train = new train("First Train", "S1-1", true, "S5-1");
		
		
		
		faultLayer faultLayer = new faultLayer();
		faultLayer.setupTracks();
		faultLayer.setupSwitches();
		faultLayer.setupStations();

		System.out.println(faultLayer.getTrackposttrack1("S1-1"));
		
		String str = faultLayer.getTrackposttrack1("S1-1");
		System.out.println(str);
		
		train.planPath();
		
		
	}
}
