package lab2.E1.observer;

public class StartObserver implements SignalObserver {

	public void updateSignal(double x) {
		for (int i = 0; i < x; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

}
