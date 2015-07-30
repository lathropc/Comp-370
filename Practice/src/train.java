public class train {
	final int id;
	int x;
	int y;
	//String frontLocation;
	//String backLocation;
	public boolean isAlive;
	int speed;
	
	Routine routine;
	Tracks tracks;
	
	public train(int id, int x, int y, boolean isAlive, int speed) {
		this.id = id;
		this.x = x;
		this.y = y;
		//this.frontLocation = frontLocation;
		//this.backLocation = backLocation;
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
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
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
	
	public int getId() {
		return id;
	}
	
	public void setTracks(Tracks tracks) {
		this.tracks = tracks;
	}
	
	@Override
	public String toString() {
		return "Train{" +
				"id=" + id +
				", x=" + x +
				", y=" + y +
				", speed=" + speed +
				'}';
	}
}