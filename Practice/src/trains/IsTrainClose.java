package trains;
public class IsTrainClose extends Routine {

	public IsTrainClose() {
	}

	@Override
	public void reset() {
		start();
	}

	@Override
	public void act(train train, Tracks tracks) {
		// figures out if train is approaching
		for (train otherTrain : tracks.getTrains()) {
			if (!train.getId().equals(otherTrain)) {
				if (isApproaching(train, otherTrain)) {
					succeed();
					break;
				}
			}
		}
		fail();
	}

	private boolean isApproaching(train train, train otherTrain) {
		return (train.getLocation() == otherTrain.getLocation());
	}
}
