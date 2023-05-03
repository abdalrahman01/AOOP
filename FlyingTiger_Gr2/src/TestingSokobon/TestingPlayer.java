package TestingSokobon;

import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import sokobon.Player;
public class TestingPlayer {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Testing Player");
		frame.setLayout(new FlowLayout() );
		
		Player player = new Player();
		System.out.println(player);
		
		frame.add(player.getIcon());
		frame.add(new JLabel("Hello"));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
