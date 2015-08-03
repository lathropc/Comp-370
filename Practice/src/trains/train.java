package trains;
public class train {
	final String id;
	String location;
	// String frontLocation;
	// String backLocation;
	public boolean isAlive;
	int speed;

	Routine routine;
	Tracks tracks;

	public train(String id, String location, boolean isAlive, int speed) {
		this.id = id;
		this.location = location;
		
		// this.frontLocation = frontLocation;
		// this.backLocation = backLocation;
		this.isAlive = isAlive;
		this.speed = speed;
	}

	public void update() {
		if (routine.getState() == null) {
			// hasn't stated yet so we start it
			routine.start();
		}
		routine.act(this, tracks);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isAlive() {
		return true;
	}

	public Routine getRoutine() {
		return getRoutine();
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public String getId() {
		return id;
	}

	public void setTracks(Tracks tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "Train{" + "id=" + id + ", location=" + location +  "speed="
				+ speed + '}';
	}

}