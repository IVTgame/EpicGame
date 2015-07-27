package org.epicgame.defaultclasses;

public class Point {

	public int x;
	public int y;

	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static double distantion2D(Point start, Point end) {
		double x = end.x - start.x;
		double y = end.y - start.y;
		return Math.sqrt(x*x + y*y);
	}
	
	public static double distantion2D(int x1, int y1, int x2, int y2) {
		return distantion2D(new Point(x1, y1), new Point(x2, y2));
	}
}
