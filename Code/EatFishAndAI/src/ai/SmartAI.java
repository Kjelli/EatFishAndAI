package ai;

import java.util.List;

import fishhandles.OtherFish;
import fishhandles.YourFish;

public class SmartAI extends AbstractAI {
	// Modify the code from here
	//

	YourFish myFish;
	OtherFish prey;
	float preyDist = 10000;
	OtherFish hunter;
	float hunterDist = 10001;

	@Override
	public void init(YourFish fish) {
		myFish = fish;
	}

	@Override
	public void act(List<OtherFish> otherFish) {
		scoutPrey(otherFish);
		scoutHunter(otherFish);

		if (preyDist <= hunterDist && prey != null && prey.isAlive()) {
			myFish.moveTowards(prey);
		} else if (hunterDist < preyDist && hunter != null && hunter.isAlive()) {
			myFish.moveFrom(hunter);
		}

	}

	private void scoutHunter(List<OtherFish> otherFish) {
		float minimumDistance = 10000;
		for (OtherFish that : otherFish) {
			if (that.greaterThan(myFish)
					&& myFish.distanceTo(that) < minimumDistance) {
				minimumDistance = myFish.distanceTo(that);
				hunterDist = minimumDistance;
				hunter = that;
			}
		}
	}

	private void scoutPrey(List<OtherFish> otherFish) {
		if (prey == null || !prey.isAlive() || headingAwayFromMe(prey, myFish)) {
			float minimumDistance = 10000;
			for (OtherFish that : otherFish) {
				if (headingAwayFromMe(that, myFish)) {
					continue;
				}
				if (myFish.greaterThan(that)
						&& myFish.distanceTo(that) < minimumDistance) {
					minimumDistance = myFish.distanceTo(that);
					preyDist = minimumDistance;
					prey = that;
				}

			}
		}
	}

	private boolean headingAwayFromMe(OtherFish prey, YourFish myFish) {
		if (prey.getVelocityX() > 0 && prey.getX() - myFish.getX() > 0) {
			return true;
		} else if (prey.getVelocityX() < 0 && myFish.getX() - prey.getX() > 0) {
			return true;
		}
		return false;
	}

}
