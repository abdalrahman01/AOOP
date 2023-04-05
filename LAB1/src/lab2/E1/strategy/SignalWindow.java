package lab2.E1.strategy;

import javax.swing.*;

public class SignalWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JTextArea jta;
	public  SignalWindow() {
		jta = new JTextArea(100,20);
		jta.append("The Signal Amplitude BY Abd Alrahman.\n");
		add(jta); // this.add
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	
	public JTextArea getTextArea() {
		return jta;
	}

}
