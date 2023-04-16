/**
 * 
 */
package lab2.E1.strategy;

/**
 * @author Abd Alrahman Atieh 
 *
 */

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import lab2.E1.strategy.DefaultSampler;
import lab2.E1.strategy.Sampler;

public class Signal {
	private double amplitude;
	private final int SAMPLING = 1000;
	
	private Sampler theSampler; 

	
	public Signal(final JTextArea jta) {
		theSampler = new DefaultSampler();
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amplitude = theSampler.read();
				jta.append(""+String.format("%.6f", amplitude)+"\n");
			}
		});
		t.start();
	}


	public void setSampler(Sampler aSampler) {
		theSampler = aSampler; 
	}

	
	
	public static void main(String[] args) {
		System.out.println("Hello start");
		
		
	}

	
}
