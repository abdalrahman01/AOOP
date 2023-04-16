package lab2.E3.Ball;

import java.awt.geom.Point2D;

public class Ball {
	private double xCenter, yCenter;
	private double rad;
	private java.awt.Color color;

	public Ball(double x, double y, double r, java.awt.Color c) {
		xCenter = x;
		yCenter = y;
		rad = r;
		color = c;
	}

	public void move(double dx, double dy) {
		xCenter += dx;
		yCenter += dy;
	}
	
	public void draw(java.awt.Graphics2D g) {
		g.setColor(color);
		java.awt.Shape aCircleInRectangle = new java.awt.geom.Ellipse2D.Double(xCenter - rad, yCenter - rad, 2 * rad,
				2 * rad);
		g.fill(aCircleInRectangle);
	}

	public boolean contains(Point2D p) {
		java.awt.Shape aCircleInRectangle = new java.awt.geom.Ellipse2D.Double(xCenter - rad, yCenter - rad, 2 * rad,
				2 * rad);
		return aCircleInRectangle.contains(p);
	}

	public void draw(java.awt.Graphics2D g, int xSize, int ySize) {
		g.setColor(color);
		java.awt.Shape aCircleInRectangle =
			new java.awt.geom.Ellipse2D.Double(xSize/4, ySize/4, xSize/2, ySize/2);
		g.fill(aCircleInRectangle);
	}

}