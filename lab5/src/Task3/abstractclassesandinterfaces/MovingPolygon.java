package Task3.abstractclassesandinterfaces;

public class MovingPolygon extends Polygon implements Moveable{

	int[] vx, vy;
	
	public MovingPolygon(int n) {

		super(n);
		vx = new int[nVertices];
		vy = new int[nVertices];
	}

	public MovingPolygon(int[] x, int[] y, int vx[], int[] vy, int n) {

		super(x, y, n);
		this.vx = vx;
		this.vy = vy;
	}

	public void move(int left, int right, int top, int bottom) {

		for (int i = 0; i < nVertices; i++) {

			x[i] += vx[i];
			y[i] += vy[i];

			if (x[i] >= right) {

				vx[i] *= -1;
				x[i] = right;

			} else if (x[i] <= left) {

				vx[i] *= -1;
				x[i] = left;
			}

			if (y[i] >= bottom) {

				vy[i] *= -1;
				y[i] = bottom;

			} else if (y[i] <= top) {

				vy[i] *= -1;
				y[i] = top;
			}

		}
	}
}
