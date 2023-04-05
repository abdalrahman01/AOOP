/**
 * 
 */
package lab2.E1.ObserverAndStrategy;

/**
 * @author Abd Alrahman Atieh 
 *
 */

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;



public class Signal {
	private double amplitude;
	private final int SAMPLING = 500;
	private ArrayList<SignalObserver> theObservers;
	
	private Sampler theSampler; 

	public void addSignalObserver(SignalObserver s) {
		theObservers.add(s);
	}

	public Signal() {
		theSampler = new DefaultSampler();
		theObservers = new ArrayList<SignalObserver>();
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextValue(theSampler.read());
			//	jta.append(""+String.format("%.6f", amplitude)+"\n");
			}
		});
		t.start();
	}

	private void nextValue(double x) {
		amplitude = x;
		for (SignalObserver so : theObservers) {
			so.updateSignal(amplitude);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello start");
		
		
	}


	public void setSampler(Sampler aSampler) {
		theSampler = aSampler; 
	}


	
}
