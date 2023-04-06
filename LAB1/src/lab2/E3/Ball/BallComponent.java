package lab2.E3.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class BallComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	private Ball theBall;
	private Point mousePoint; // coordinates
	
	public BallComponent(Ball b,int width, int height) {
		theBall = b;
		setPreferredSize(new Dimension(width, height));
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				mousePoint = event.getPoint();
				if(!theBall.contains(mousePoint))
					mousePoint = null;
				System.out.println(mousePoint);
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent event) {
				if(mousePoint == null) return;
				Point lastPoint = mousePoint;
				mousePoint = event.getPoint();
				double dx = mousePoint.getX() - lastPoint.getX();
				double dy = mousePoint.getY() - lastPoint.getY();
				theBall.move(dx, dy);
				repaint();
			}
		});
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		theBall.draw(g2);
		// theBall.draw(g2, this.getWidth(), this.getHeight());
	}

}