package TestingSokobon;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import sokobon.Goal;
public class TestingGoal {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Testing Goal");
		frame.setLayout(new FlowLayout());
		
		Goal goal = new Goal();
		frame.add(goal.getIcon()); 
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
	}
}
