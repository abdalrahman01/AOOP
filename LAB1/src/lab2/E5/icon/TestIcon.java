package lab2.E5.icon;

import javax.swing.JOptionPane;

public class TestIcon {
	public static void main(String[] args) {
		
		
		CompositeIcon frame = new CompositeIcon(200, 300);
		
		CarIcon car = new CarIcon(40);
		CarIcon car2 = new CarIcon(20);
		frame.addIcon(car, 0, 0);
		frame.addIcon(car, 50, 0);
		frame.addIcon(car, 0, 50);
		frame.addIcon(car, 100, 0);
		frame.addIcon(car2, 39, 100);
		
		JOptionPane.showMessageDialog(
		         null,
		         "Hello, Mars!",
		         "Message",
		         JOptionPane.INFORMATION_MESSAGE,
		         frame);
		      System.exit(0);
		   }
		
	}

