package Exercise15;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleFrame {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		final int FIELD_WIDTH = 20;
		JTextField textField = new JTextField(FIELD_WIDTH);
		textField.setText("Click a button!");

		JButton helloButton = new JButton("Say Hello");
		JButton goodbyeButton = new JButton("Say Goodbye");

		frame.setLayout(new FlowLayout());

		/*
		helloButton.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello!");
			}
		});

		helloButton.addActionListener(new  ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("Hello!");
			}
		});
		*/
		helloButton.addActionListener(new GreeterClass(textField, "Hello!"));
		goodbyeButton.addActionListener(new GreeterClass(textField, "Good bye!"));
		
		Timer t = new Timer(1000, new TimeStamp(textField));
		t.start();
		
		frame.add(textField);
		frame.add(helloButton);
		frame.add(goodbyeButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	
	}
}
