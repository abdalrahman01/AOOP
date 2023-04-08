package lab2.E5.icon;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Icon;

public class CompositeIcon implements Icon {

	private List<Icon> childrenIcons;
	private List<Point> childrenIconsLocations;
	private int width, height;
	
	public CompositeIcon(int w, int h) {
		height =  h;
		width = w; 
		childrenIconsLocations = new ArrayList<Point>();
		childrenIcons = new LinkedList<Icon>(); 
	}
	
	
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		int i = 0; 
		Point location; 
		for (Icon icon : childrenIcons) {
			location = childrenIconsLocations.get(i++);
			icon.paintIcon(c, g, x + location.x ,y + location.y);
		}
		
	}
	public int getIconWidth() {
		return width;
	}
	public int getIconHeight() {
		return height; 
	}
	
	public void addIcon(Icon icon, int x, int y) {
		childrenIconsLocations.add(new Point(x,y));
		childrenIcons.add(icon);
	}
	
}
