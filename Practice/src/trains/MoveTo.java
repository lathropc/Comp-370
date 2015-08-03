package trains;
public class MoveTo extends Routine {

	final protected String destination;

	public MoveTo(String destination) {
		super();
		this.destination = destination;
	}

	public void reset() {
		start();
	}

	@Override
	public void act(train train, Tracks tracks) {
		if (isRunning()) {
			if (!train.isAlive()) {
				fail();
				return;
			}
			if (!isTrainAtDestination(train)) {
				moveTrain(train);
			}
		}
	}

	private void moveTrain(train train) {
		//shit to move trains
	}

	private boolean isTrainAtDestination(train train) {
		return destination == train.getLocation();
	}
}
