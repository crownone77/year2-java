package simpleobjects;

import goo.Goo; // A

import java.awt.*;

public class GooDrop extends Goo { // B

	//SimpleDrop drop;
    //RedDrop drop;
    //VerticalBounceDrop drop;
    HalfVerticalBounceDrop drop;

	public GooDrop(int width, int height) { // C

		super(width, height);

		int xpos = width / 2;
		int ypos = 0;
        /*
        to make the drop start from the bottom left of the screen
        xpos = 0
        ypos = height;
         */
		int xvel = 0;
		int yvel = 10;
		int size = 10;

		//drop = new SimpleDrop(xpos, ypos, xvel, yvel, size);
		//drop = new RedDrop(xpos, ypos, xvel, yvel, size);
        drop = new HalfVerticalBounceDrop(xpos, ypos, xvel, yvel, size);
        //drop = new VerticalBounceDrop(xpos, ypos, xvel, yvel, size);


	}

	public void draw(Graphics g) { // D

		drop.move(getWidth(), getHeight());
		drop.draw(g);
	}
}
