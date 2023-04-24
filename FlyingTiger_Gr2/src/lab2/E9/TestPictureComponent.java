package lab2.E9;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class TestPictureComponent {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Picture Component");
		frame.setLayout(new GridLayout());
		frame.setSize(500, 400);
		final PictureComponent pictureComponent = new PictureComponent();
		File img;
		final File img2; 
		img = new File("C:/Users/Abd Alrahman/git/AOOP/FlyingTiger_Gr2/src/lab2/E9/images/imgs/1.png");
		img2 = new File("C:/Users/Abd Alrahman/git/AOOP/FlyingTiger_Gr2/src/lab2/E9/images/imgs/2.png");
		
		try {			
			pictureComponent.setDisplayedImage(img);
		
		} catch (IOException e) {
			System.err.println(e + "  " + img);
		}
		

		frame.add(pictureComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton next = new JButton("Next Pic");
		
		next.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				try {			
					pictureComponent.setDisplayedImage(img2);
				
				} catch (IOException e) {
					System.err.println(e + "  " + img2);
				}
				
			}
		});
		
		// show frame	
		frame.add(next);
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
