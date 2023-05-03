package TestingSokobon;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import sokobon.Player;
public class TestingPlayer {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Testing Player");
		frame.setLayout(new FlowLayout() );
		
		Player player = new Player();
		frame.add(player);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
