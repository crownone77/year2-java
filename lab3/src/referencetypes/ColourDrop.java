package referencetypes;

import java.awt.*;

public class ColourDrop extends Drop {

	Color color;

	public ColourDrop(int x, int y, int vx, int vy, int sz, Color c) {

		super(x, y, vx, vy, sz); 
		color = c;
	}

	public void move(int width, int height){

        //get the drop moving
        xpos += xvel;
        ypos += yvel;

        //when the drop hits left or right side
        if (xpos < 0 || xpos > width-size){
            xvel = -xvel;
            Toolkit.getDefaultToolkit().beep();
        }

        //when the drop hits top or bottom
        if (ypos < 0 || ypos > height-size){
            yvel = -yvel;
            Toolkit.getDefaultToolkit().beep();
        }
    }

	public void draw(Graphics g){
		
		g.setColor(color);
		g.fillOval(xpos, ypos, size, size);
	}
}
