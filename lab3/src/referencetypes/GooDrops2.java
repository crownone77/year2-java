package referencetypes;

import goo.Goo;

import java.awt.*;
import java.util.Random;

public class GooDrops2 extends Goo {

	private Drop[] drops;
	private int numDrops, maxSize = 9, maxVel = 9;
	private Random random;

	public GooDrops2(int w, int h, int nd) {

		super(w, h);
		numDrops = nd;

		drops = new Drop[numDrops];
		random = new Random(1962); 

		for (int i = 0; i < numDrops-1; i++) {

			int xpos = random.nextInt(w);
			int ypos = random.nextInt(h);
			int xvel = 0;
			int yvel = 1 + random.nextInt(maxVel);
			//int size = 1 + random.nextInt(maxSize);
            int size = 16;
			drops[i] = makeDrop(xpos, ypos, xvel, yvel, size);
		}

		Color green = Color.GREEN;
        ColourDrop cd = new ColourDrop(10, 10, 20, 20, 40, green);
		drops[numDrops-1] = cd;
	}
	
	public Drop makeDrop(int xpos, int ypos,int xvel,int yvel, 
			      int size){
		
		return new Drop(xpos, ypos, xvel, yvel, size);
	}

	public void draw(Graphics g) {

		for (int i = 0; i < numDrops; i++) {

			drops[i].move(getWidth(), getHeight());
			drops[i].draw(g);
		}
	}

	public Drop[] getDrops(){
		
		return drops;
	}
	
	public Random getRandom(){
		
		return random;
	}
	
	public static void main(String[] args) {

		int width = 800;
		int height = 500;
		int numDrops = 40;
		GooDrops2 gd = new GooDrops2(width, height, numDrops);

        Drop[]dropArr = gd.getDrops();
        Drop greenDrop = dropArr[numDrops-1];

        gd.background(0);
        gd.frameRate(60);
		gd.smooth();
		gd.go();
    }
}
