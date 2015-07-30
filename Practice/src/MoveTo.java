
public class MoveTo extends Routine {
	
	final protected int destX;
	final protected int destY;
	
	public MoveTo(int destX, int destY) {
		super();
		this.destX = destX;
		this.destY = destY;
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
		if (destY != train.getY()) {
			if (destY > train.getY()) {
				train.setY(train.getY() + 1);
			} else {
				train.setY(train.getY() - 1);
			}
		}
		if (destX != train.getX()) {
			if (destX > train.getX()) {
				train.setX(train.getX() + 1);
			} else {
				train.setX(train.getX() - 1);
			}
		}
		if (isTrainAtDestination(train)) {
			succeed();
		}
	}
	
	private boolean isTrainAtDestination(train train) {
		return destX == train.getX() && destY == train.getY();
	}
}
