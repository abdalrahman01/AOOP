package TestingSokobon;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import sokobon.MovingBox;


public class TestingMovingBox {
	public static void main (String[] args) {
		JFrame frame = new JFrame ("Testing MovingBox");
		frame.setLayout(new FlowLayout());
		
		MovingBox box = new MovingBox();
		frame.add(box);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
