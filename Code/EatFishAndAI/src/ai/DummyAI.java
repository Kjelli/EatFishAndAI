package ai;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

import java.util.List;

import fishhandles.OtherFish;
import fishhandles.YourFish;

public class DummyAI extends AbstractAI {
	int angle;
	YourFish fish;

	public DummyAI() {
		angle = (int) (Math.random() * 360);
	}

	@Override
	public void init(YourFish fish) {
		this.fish = fish;
	}

	@Override
	public void update(List<OtherFish> otherFish) {
		fish.setVelocityY((float) (cos(angle * PI / 180.0f) / 3));
		angle = (angle + 1) % 360;
	}

	@Override
	public void ateFish(OtherFish handle) {

	}

}
