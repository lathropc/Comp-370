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
		if (isTrackMoveable(train.getX(), train.getY())) {
			trains.add(train);
			train.setTracks(this);
		}
	}
	
	public boolean isTrackMoveable(int x, int y) {
		for (train train : trains) {
			if (train.getX() == x && train.getY() == y) {
				return false;
			}
		}
		return true;
	}
	
	public List<train> getTrains() {
		return trains;
	}

}
