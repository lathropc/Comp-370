package trains;
import java.util.Random;

public class RandomRoute extends Routine {

	private static Random random = new Random();
	private final Tracks tracks;
	private MoveTo moveTo;

	@Override
	public void start() {
		super.start();
		this.moveTo.start();
	}

	public void reset() {
		this.moveTo = new MoveTo(random.nextInt(tracks.getWidth()),
				random.nextInt(tracks.getHeight()));
	}

	public RandomRoute(Tracks tracks) {
		super();
		this.tracks = tracks;
		this.moveTo = new MoveTo(random.nextInt(tracks.getWidth()),
				random.nextInt(tracks.getHeight()));
	}

	@Override
	public void act(train train, Tracks tracks) {
		if (!moveTo.isRunning()) {
			return;
		}
		this.moveTo.act(train, tracks);
		if (this.moveTo.isSuccess()) {
			succeed();
		} else if (this.moveTo.isFailure()) {
			fail();
		}
	}
}
