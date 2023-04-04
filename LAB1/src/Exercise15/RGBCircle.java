/**
 * 
 */
package Exercise15;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.*;
/**
 * @author Abd Alrahman
 *
 */
public class RGBCircle {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton redButton = new JButton("Red");
		JButton greenButton = new JButton("Green");
		JButton blueButton = new JButton("Blue");
		
		final JLabel circle = new JLabel(new CircleIcon(Color.RED));
		
		circle.setSize(400, 400);
		frame.setLayout(new BorderLayout());
		frame.add(redButton, BorderLayout.NORTH);
		frame.add(greenButton, BorderLayout.WEST);
		frame.add(blueButton, BorderLayout.EAST);
		frame.add(circle, BorderLayout.CENTER);
		
		
		
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				((CircleIcon) circle.getIcon() ).setColor(Color.RED);
				circle.repaint();
			}
		} );
		
		greenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				((CircleIcon) circle.getIcon() ).setColor(Color.GREEN);
				circle.repaint();
			}
		} );
		
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				((CircleIcon) circle.getIcon() ).setColor(Color.BLUE);
				circle.repaint();
			}
		} );
		frame.pack();
		frame.setVisible(true);
		
		

	}

}
