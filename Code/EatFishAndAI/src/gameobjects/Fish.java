package gameobjects;

import ai.AI;

public interface Fish extends GameObject, Comparable<Fish> {
	public static final float MASS_DIFFERENCE_MARGIN = 0.1f;
	public final static int BUBBLE_TIMER_MAX = 1500, BUBBLE_TIMER_MIN = 100;
	public final static int EATING_COOLDOWN_MAX = 1;
	public static final float BUBBLE_SCALE = 0.8f;
	public static final float GROWTH_FACTOR = 0.2f;
	public static final float SLOW_FACTOR = 0.9f;
	public static final float MAX_SPEED = 50;

	float getSize();

	void setSize(float size);

	void attachAI(AI ai);

	void eat(Fish fish);

}
