package Task3.abstractclassesandinterfaces;

import java.awt.Graphics;

public class Polygon extends Shape {

	public Polygon(int n) {

		super(n);
	}

	public Polygon(int[] x, int[] y, int n) {

		super(x, y, n);
	}

	public void draw(Graphics g) {

		g.setColor(color);

		for (int i = 0; i < nVertices - 1; i++) {

			g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
		}

		g.drawLine(x[nVertices - 1], y[nVertices - 1], x[0], y[0]);
	}
	
	public void fill(Graphics g){
		
		g.setColor(color);
		g.fillPolygon(x, y, nVertices);
	}
}
