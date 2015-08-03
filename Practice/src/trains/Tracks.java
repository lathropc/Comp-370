package trains;
import java.util.ArrayList;
import java.util.List;

public class Tracks {

	final int width;
	final int height;

	private List<train> trains = new ArrayList<train>();

	public Tracks(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void addTrain(train train) {
		if (isTrackMoveable(train.getLocation())) {
			trains.add(train);
			train.setTracks(this);
		}
	}

	public boolean isTrackMoveable(String location) {
		for (train train : trains) {
			if (train.getLocation() == location) {
				return false;
			}
		}
		return true;
	}

	public List<train> getTrains() {
		return trains;
	}

}
