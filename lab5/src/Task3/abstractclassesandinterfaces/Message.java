package Task3.abstractclassesandinterfaces;

import java.awt.Color;
import java.awt.Graphics;

public class Message implements Drawable {

	int x;
	String message;

	public Message(String msg, int x) {
		
		message = msg;
		this.x = x;
	}

	public void draw(Graphics g) {

		g.setColor(Color.BLACK);
		g.drawString(message, (int) (x + 0.5), 50);
	}
}
