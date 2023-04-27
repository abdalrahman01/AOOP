package lab2.E9;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import javax.swing.JComponent;
import javax.swing.JFrame;


public class SlideShow extends Presenter {

	private List<File> images; 
	private String[] texts;
	
	private int currentImage = 0; // indicates which image is displayed from list.
	
	private PictureComponent pictureComponent;
	
	public SlideShow(File[] imageFiles, String[] texts) {
		super();
		this.images = Arrays.asList(imageFiles);
		
		this.texts = Arrays.copyOf(texts, texts.length);
		
		
		// read and remember (create instance variables)
		// images from the indicated files
		// and also remember texts in an instance field
	}
	
	@Override
	public JComponent createCenterComponent() {
		
		pictureComponent = new PictureComponent();
		
		
		return pictureComponent;
	}

	@Override
	public void eastButtonPressed() {
		// make pictureComponent display the next picture
		// call showText(...) to update the text associated with picture
		// one possible way of drawing images is
		// in paintComponent
		// BufferedImage image = ImageIO.read(<File object>);
		// Graphics2D g2 = (Graphics2D)g;
		// g2.drawImage(image, null, <posX>, <posY>);
		// Google will give details
		currentImage = (currentImage + 1) % images.size();  
		try {
			((PictureComponent) pictureComponent).setDisplayedImage(images.get(currentImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showText(texts[currentImage]);
		
	}
	
	@Override
	public void westButtonPressed() {
		// same as for east button, but for previous picture
		currentImage--;
		if (currentImage < 0)
			currentImage = images.size() - 1;
		try {
			((PictureComponent) pictureComponent).setDisplayedImage(images.get(currentImage));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		showText(texts[currentImage]);
	}

	@Override
	public void southButtonPressed() {
	}

	@Override
	public void northButtonPressed() {
	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		SlideShow app = new SlideShow(
				new File[] {	new File("src/lab2/E9/imgs/1.png"), 
								new File("src/lab2/E9/imgs/2.png"), 
								new File("src/lab2/E9/imgs/3.png")
								},
				new String[] {"Descirption 1", "Description 2", "Description 3"});				
	}

}
