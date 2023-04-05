/**
 * 
 */
package lab2.E1;

/**
 * @author Abd Alrahman Atieh 
 *
 */

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Signal {
	private double amplitude;
	private final int SAMPLING = 50;
	private ArrayList<SignalObserver> theObservers;

	public void addSignalObserver(SignalObserver s) {
		theObservers.add(s);
	}

	public Signal() {
		theObservers = new ArrayList<SignalObserver>();
		Timer t = new Timer(SAMPLING, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextValue(Math.random() * 100);
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

	private static void printStar(int x) {
		
		for (int i = 0; i < x; i++) {
			System.out.print("*");
		}
		System.out.println();

	}
	
	public static void main(String[] args) {
		System.out.println("Hello start");
		Signal s = new Signal();
		s.addSignalObserver(new SignalObserver() {

			public void updateSignal(double x) {

				printStar((int) x);

			}

		});
		while(true) {}
		
	}

	
}
