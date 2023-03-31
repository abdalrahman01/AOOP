package Exercise15;

import java.awt.*;

import javax.swing.*;

public class Clock {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		final int FIELD_WIDTH = 20;
		JTextField textField = new JTextField(FIELD_WIDTH);
		textField.setText("A clock");

		frame.setLayout(new FlowLayout());

		frame.add(textField);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
