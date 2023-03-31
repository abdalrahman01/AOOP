package Exercise15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class GreeterClass implements ActionListener {
	private JTextField tf;
	private String greeting;
	
	public GreeterClass(JTextField tf, String greeting) {
		this.tf = tf;
		this.greeting = greeting;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		tf.setText(greeting);
	}

}
