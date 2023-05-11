package lab2.E9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JPanel;

public abstract class Presenter {

	public abstract JComponent createCenterComponent();
	
	public abstract void northButtonPressed();
	public abstract void eastButtonPressed();
	public abstract void southButtonPressed();
	public abstract void westButtonPressed();
	
	private String msg = "Default Message is Very Bet!";
	
	private JLabel textfield;
	public JComponent centerComponent;
	JButton northButton;
	JButton southButton;
	JButton eastButton;
	JButton westButton;
	JPanel buttonsPanel;
	int width = 20;
	int height = 20;
	
	public Presenter(){
		
		
		// setup layout manager for frame
		JFrame frame = new JFrame("Presenter");
		
		frame.setLayout(new GridLayout());
		
		
		northButton = new JButton("UP");
		
		northButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				northButtonPressed();				
			}
		});
		
		southButton = new JButton("DOWN");
		southButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				southButtonPressed();				
			}
		});
		eastButton = new JButton("LEFT");
		eastButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				eastButtonPressed();				
			}
		});
		westButton = new JButton("RIGHT");
		westButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				westButtonPressed();				
			}
		});
		
		
		// add Buttons to a JPanel, add that panel to frame
		buttonsPanel = new JPanel(new BorderLayout()); 
	
		buttonsPanel.add(northButton, BorderLayout.NORTH);
		buttonsPanel.add(southButton, BorderLayout.SOUTH);
		buttonsPanel.add(westButton, BorderLayout.WEST);
		buttonsPanel.add(eastButton, BorderLayout.EAST);
		frame.add(buttonsPanel);
		
		

		// add main panels to frame
		frame.add(buttonsPanel, BorderLayout.CENTER);
		
//		 add centerComponent to frame
	//	centerComponent = createCenterComponent();
	//	if(centerComponent != null) {
		//    frame.add(centerComponent);
	//	}
		
		// create other components (text component, e.g.), add them to frame
		textfield = new JLabel(msg);
		frame.add(textfield, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// show frame	
		
		frame.pack();
		frame.setVisible(true);
		//System.out.println( "in Pres" + centerComponent);
		
		
		
	}
	
	public void showText(String text) {
		msg = text;
		textfield.setText(msg);
	}
	
	public void changeNorthButtonIcon(File file) {
	    try {
	        BufferedImage mainImage = ImageIO.read(file);
	        BufferedImage resizeImage = new BufferedImage(width, height, mainImage.getType());
	        Graphics2D graph = resizeImage.createGraphics();
	        graph.drawImage(mainImage, 0, 0, width, height, null);
	        graph.dispose();
	        ImageIcon icon = new ImageIcon(resizeImage);
	        northButton.setIcon(icon);
	        northButton.setPreferredSize(new Dimension(20, 30));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	  
	    
	}

	public void changeSouthButtonIcon(File file) {
	    try {
	        BufferedImage mainImage = ImageIO.read(file);
	        BufferedImage resizeImage = new BufferedImage(width, height, mainImage.getType());
	        Graphics2D graph = resizeImage.createGraphics();
	        graph.drawImage(mainImage, 0, 0, width, height, null);
	        graph.dispose();
	        ImageIcon icon = new ImageIcon(resizeImage);       
	        southButton.setIcon(icon);
	        southButton.setPreferredSize(new Dimension(20, 30));
	     
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void changeWestButtonIcon(File file) {
	    try {
	        BufferedImage mainImage = ImageIO.read(file);
	        BufferedImage resizeImage = new BufferedImage(width, height, mainImage.getType());
	        Graphics2D graph = resizeImage.createGraphics();
	        graph.drawImage(mainImage, 0, 0, width, height, null);
	        graph.dispose();
	        ImageIcon icon = new ImageIcon(resizeImage);
	        westButton.setIcon(icon);
	        westButton.setPreferredSize(new Dimension(100, 30));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void changeEastButtonIcon(File file) {
	    try {
	        BufferedImage mainImage = ImageIO.read(file);
	        BufferedImage resizeImage = new BufferedImage(width, height, mainImage.getType());
	        Graphics2D graph = resizeImage.createGraphics();
	        graph.drawImage(mainImage, 0, 0, width, height, null);
	        graph.dispose();
	        ImageIcon icon = new ImageIcon(resizeImage);
	        eastButton.setIcon(icon);
	        eastButton.setPreferredSize(new Dimension(100, 30));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
