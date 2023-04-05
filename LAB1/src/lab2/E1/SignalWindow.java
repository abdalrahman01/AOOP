package lab2.E1;

import javax.swing.*;

public class SignalWindow extends JFrame implements SignalObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JTextArea jta;
	public  SignalWindow() {
		jta = new JTextArea(100,20);
		jta.append("The Signal Amplitude.\n");
		add(jta); // this.add
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
	public void updateSignal(double x) {
		jta.append("" + x+ "\n");
		
	}
	
	public JTextArea getTextArea() {
		return jta;
	}

}
