package lab2.E3.Ball;

import javax.swing.*;

public class TestBall {
	public static void main(String[] args) {

		JFrame frame = new JFrame();

		Ball b = new Ball(200, 200, 50, java.awt.Color.RED);

		frame.add(new BallComponent(b, 400, 400));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}