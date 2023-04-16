package lab2.E1.ObserverAndStrategy;

public class StarObserver implements SignalObserver {

	public void updateSignal(double x) {
		for (int i = 0; i < x; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

}
