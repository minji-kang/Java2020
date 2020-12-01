// rectangle collision
// assignment
import java.util.*;

// given by professor
class Point {
	private int x, y;
	public Point(int x, int y) { this.x = x; this.y = y; }
	public int getX() { return x; }
	public int getY() { return y; }
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// defining rectangles
// (x, y) point for the bottom left
class RectPoint extends Point {
	private int width, height;
	
	public RectPoint(int x, int y, int w, int h) {
		super(x, y);
		this.width = w;
		this.height = h;
	}
	
	protected void modify(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	public int perimeter() {
		int peri = (width + height) * 2;
		return peri;
	}
	
	public int area() {
		int area = width * height;
		return area;
	}
	
	public static boolean collision(RectPoint r1, RectPoint r2) {
		// true : collision occurs; false: collision does not occur
		// inspect if the right side of r1 collides with the left side of r2 
		int right = r1.getX() + r1.width;
		int left = r2.getX();
		if (right < left) return false;
		// inspect if the top of r1 collides with the bottom of r2
		int top = r1.getY() + r1.height;
		int bottom = r2.getY();
		if (top < bottom) return false;
		// inspect if the left side of r1 collides with the right side of r2
		left = r1.getX();
		right = r2.getX() + r2.width;
		if (right < left) return false;
		// inspect if the bottom of r1 collides with the top of r2
		bottom = r1.getY();
		top = r2.getY() + r2.height;
		if (top < bottom) return false;
		return true;
	}
}

// rectangles on the first quadrant
class RectPointP extends RectPoint {
	public RectPointP(int x, int y, int w, int h) {
		super(x, y, w, h);
	}	
	
	public void move(int x, int y) {
		super.move(x, y);
		// if the bottom left coordinate is negative, make it zero
		if (x < 0) this.move(0, y);
		if (y < 0) this.move(x, 0);
	}
}

public class P420170154 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numInst = 0;
		do {
			System.out.print("Number of Rectangles: ");
			numInst = sc.nextInt();
		} while (numInst < 5 && numInst < 2);
		
		RectPointP[] rects = new RectPointP[numInst];
		
		System.out.println();
		int x, y, w, h, i;
		for (i = 0; i < rects.length; i++) {
			System.out.println("Number " + i + " Rectangle");
			System.out.print("  x = ");
			x = sc.nextInt();
			System.out.print("  y = ");
			y = sc.nextInt();
			System.out.print("  width = ");
			w = sc.nextInt();
			System.out.print("  height = ");
			h = sc.nextInt();
			rects[i] = new RectPointP(x, y, w, h);
		}
		
		System.out.println();
		while (true) {
			System.out.print("[1.Move 2.Collision Check 0.Exit] : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.print("Rectangle Number for Moving : ");
				i = sc.nextInt();
				System.out.print("  x = ");
				x = sc.nextInt();
				System.out.print("  y = ");
				y = sc.nextInt();
				rects[i].move(x, y);
				break;
			case 2:
				System.out.print("Check Rectangle Number : ");
				i = sc.nextInt();
				System.out.print("And Rectangle Number : ");
				int j = sc.nextInt();
				if (RectPointP.collision(rects[i], rects[j]))
					System.out.println("Collisions Occurence");
				else System.out.println("No Collisions");
				break;
			case 0: break;
			}
			if (num == 0) break;
			System.out.println();
		}
	}
}
