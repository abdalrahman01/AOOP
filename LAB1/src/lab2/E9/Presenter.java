package lab2.E9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Presenter {

	public abstract JComponent createCenterComponent();
	
	public abstract void northButtonPressed();
	public abstract void eastButtonPressed();
	public abstract void southButtonPressed();
	public abstract void westButtonPressed();
	
	public Presenter() {
		// setup layout manager for frame
		JFrame frame = new JFrame();
		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		
		
		JButton northButton = new JButton("North");
		northButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				northButtonPressed();				
			}
		});
		JButton southButton = new JButton("South");
		northButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				southButtonPressed();				
			}
		});
		JButton eastButton = new JButton("East");
		northButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				eastButtonPressed();				
			}
		});
		JButton westButton = new JButton("West");
		northButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				westButtonPressed();				
			}
		});
		
		
		// add Buttons to a JPanel, add that panel to frame
		JPanel buttonsPanel = new JPanel(); 
		buttonsPanel.setLayout(new BorderLayout());
		buttonsPanel.add(northButton, BorderLayout.NORTH);
		buttonsPanel.add(southButton, BorderLayout.SOUTH);
		buttonsPanel.add(westButton, BorderLayout.WEST);
		buttonsPanel.add(eastButton, BorderLayout.EAST);
		frame.add(buttonsPanel);
		
		
		// add centerComponent to frame
		JComponent centerComponent = createCenterComponent();
		frame.add(centerComponent);
		
		// create other components (text component, e.g.), add them to frame
		JLabel textfield = new JLabel("TEST!!");
		frame.add(textfield);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// show frame		
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	public void showText(String text) {
		// update the text component
	}
	
}
