package referencetypes;

import java.awt.Color;
import java.util.Random;

import referencetypes.Drop;
import referencetypes.GooDrops;

public class GooDropsInColour extends GooDrops {

	public GooDropsInColour(int w, int h, int nd) {

		super(w, h, nd);
	}

	public Drop makeDrop(int xpos, int ypos, int xvel, int yvel, int size) {

		Random random = getRandom();
		Color color = new Color(random.nextInt(256), random.nextInt(256),
				random.nextInt(256));
		return new ColourDrop(xpos, ypos, xvel, yvel, size, color);
	}

	public static void main(String[] args) {
		
		int width = 800;
		int height = 500;
		int numDrops = 200;
				
		GooDrops gd = new GooDropsInColour(width, height, numDrops);
		
		gd.background(0); // black background
		gd.frameRate(25); // 25 frames per sec
		gd.smooth();
		gd.go();
	}
}
