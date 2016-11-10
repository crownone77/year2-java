package Task3.abstractclassesandinterfaces;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Drawable{

	protected int[] x, y;
	protected int nVertices;
	protected Color color = Color.BLACK;
	
	public Shape(int n) {
		
		nVertices = n;
		x = new int[n];
		y = new int[n];
	}

	public Shape(int[] x, int[] y, int n) {

		this.x = x;
		this.y = y;
		nVertices = n;
	}
	
	public abstract void fill(Graphics g);
	
	public Color getColor(){
		
		return color;
	}
	
	public void setColor(Color c){
		
		color = c;
	}
}
