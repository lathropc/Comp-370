
public class IsTrainClose extends Routine {
	
	public IsTrainClose() {}
	
	@Override 
	public void reset() {
		start();
	}
	
	@Override
	public void act(train train, Tracks tracks) {
		//figures out if train is approaching
		for (train otherTrain : train.getTrains()) {
			if (!train.getName().equals(otherTrain)) {
				if(isApproaching(train, otherTrain)) {
					succeed();
					break;
				}
			}
		}
		fail();
	}
	
	private boolean isApproaching(train train, train otherTrain) {
		return (Math.abs(train.getX() - otherTrain.getX()) <= train.getRange()
				|| Math.abs(train.getY() - otherTrain.getY()) < train.getRange());
	}
}
