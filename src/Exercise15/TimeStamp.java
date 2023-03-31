package Exercise15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;

public class TimeStamp implements ActionListener {
	private JTextField tf;
	
	public TimeStamp(JTextField tf) {
		this.tf = tf;
	}
	

	public void actionPerformed(ActionEvent e) {
		tf.setText(new Date().toString());

	}

}
