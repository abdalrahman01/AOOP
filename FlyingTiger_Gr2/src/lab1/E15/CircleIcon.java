package lab1.E15;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import javax.swing.Icon;

public class CircleIcon implements Icon {

	
	java.awt.Color color; 
	
	public CircleIcon(java.awt.Color c) {
		color = c; 
	}
	
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g; 
		Double circle = new Ellipse2D.Double(x, y, 100, 100);
		g2.setColor(color);
		g2.fill(circle);
		
		

	}
	
	public java.awt.Color getColor() {
		return color;
	}


	public void setColor(java.awt.Color color) {
		this.color = color;
	}


	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

}
