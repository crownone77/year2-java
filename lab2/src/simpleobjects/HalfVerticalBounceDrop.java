package simpleobjects;

public class HalfVerticalBounceDrop extends Drop {

    private int ceiling = 0;
    private int divisor = 2;

	public HalfVerticalBounceDrop(int xpos, int ypos, int xvel, int yvel, int size) {

		super(xpos, ypos, xvel, yvel, size);
	}

    public void move(int width, int height){ // E

        ypos += yvel;

        //when reaches top of the screen
        if (ypos < ceiling){
            yvel = -yvel;
        }

        //if drop reaches bottom of screen
        if (ypos > height){
            yvel = -yvel;
            changeCeiling(height);
        }

    }

    private void changeCeiling(int height){
        ceiling = height - (height / divisor);
        divisor *= 2;
    }
}
