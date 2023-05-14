package TestingSokobon;



import java.awt.FlowLayout;
import javax.swing.JFrame;

import sokobon.GameObjects.Wall;


public class TestingWall {
	public static void main (String[] args) {
		JFrame frame = new JFrame ("Testing Wall");
		frame.setLayout(new FlowLayout());
		
		Wall box = new Wall();
		frame.add(box.getIcon());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
