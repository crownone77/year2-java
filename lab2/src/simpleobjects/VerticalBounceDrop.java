package simpleobjects;

public class VerticalBounceDrop extends Drop {

	public VerticalBounceDrop(int xpos, int ypos, int xvel, int yvel, int size) {

		super(xpos, ypos, xvel, yvel, size);
	}

    public void move(int width, int height){ // E

        ypos += yvel;
        if (ypos > height || ypos < 0){
            yvel = -yvel;
        }

    }
}
