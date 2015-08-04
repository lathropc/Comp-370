package trains;

import com.google.gson.Gson;

public class MoveTo extends Routine {

	final protected String destination;
	
	Gson gson = new Gson();

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
		if (train.getLocation() == null) {
			
		}
		
	}

	private boolean isTrainAtDestination(train train) {
		return destination == train.getLocation();
	}
}
