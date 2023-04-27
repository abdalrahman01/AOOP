package lab2.E9;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class TestPictureComponent {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Picture Component");
		frame.setLayout(new GridLayout());
		frame.setSize(500, 400);
		final JComponent pictureComponent = new PictureComponent();
		File img;
		final File img2; 
		img = new File("src/lab2/E9/imgs/1.png");
		img2 = new File("src/lab2/E9/imgs/2.png");
		
	

		
		JButton next = new JButton("Next Pic");
		
		next.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				try {			
					((PictureComponent)pictureComponent).setDisplayedImage(img2);
				
				} catch (IOException e) {
					System.err.println(e + "  " + img2);
				}
				
			}
		});
		
		// show frame	
		frame.add(pictureComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(next);
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
