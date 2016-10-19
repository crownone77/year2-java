package simpleobjects;

public class WobblyUp extends Drop {

	public WobblyUp(int xpos, int ypos, int xvel, int yvel, int size) {

		super(xpos, ypos, xvel, yvel, size);
	}

	public void move(int width, int height) {

		xpos = xpos - (int)(4 * (Math.random() - 0.5));
		ypos = ypos - yvel;

		if (ypos < 0) {
			
			ypos = height;
			xpos = (int) (Math.random() * width);
		}
	}
}
