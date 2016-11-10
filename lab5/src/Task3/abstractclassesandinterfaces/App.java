package Task3.abstractclassesandinterfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Task3.goo.Goo;

public class App extends Goo {

	ArrayList<Moveable> movingObjects;
	ArrayList<Drawable> drawingObjects;

	Random random;
	public App(int w, int h) {
		
		super(w, h);
		random = new Random();
		
		movingObjects = new ArrayList<Moveable>();
		drawingObjects = new ArrayList<Drawable>();
		
		int nVertices = 10;
		int maxSpeed = 10;
		
		int width = getWidth();
		int height = getHeight();
		int[] x = new int[nVertices];
		int[] y = new int[nVertices];
		int[] vx = new int[nVertices];
		int[] vy = new int[nVertices];

		for (int i = 0; i < nVertices; i++) {

			x[i] = random.nextInt(width);
			y[i] = random.nextInt(height);
			vx[i] = 1 + random.nextInt(maxSpeed - 1);
			if (random.nextDouble() > 0.5)
				vx[i] *= -1;

			vy[i] = 1 + random.nextInt(maxSpeed - 1);
			if (random.nextDouble() > 0.5)
				vy[i] *= -1;
		}

		MovingPolygon poly = new MovingPolygon(x, y, vx, vy, nVertices);

		Color color = new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255));
		poly.setColor(color);
		
		drawingObjects.add(poly);
		movingObjects.add((Moveable)poly);
		
		Message drawString = new Message("You are watching a moving polygon", 50);
		drawingObjects.add(drawString);
	}

	public void draw(Graphics g) {

		for (Drawable obj : drawingObjects) {
			obj.draw(g);
		}
		for (Moveable obj : movingObjects) {
			obj.move(0, getWidth(), 0, getHeight());
		}
	}

	public static void main(String[] args) {
		
		Goo goo = new App(500, 500);
		goo.smooth();
		goo.go();
	}
}
