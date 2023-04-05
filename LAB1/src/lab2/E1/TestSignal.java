package lab2.E1;

public class TestSignal {
	public static void main(String[] args) {
		SignalWindow sw = new SignalWindow();
		new Signal(sw.getTextArea());

		Signal s = new Signal(sw.getTextArea());
		s.addSignalObserver(new SignalObserver() {

			public void updateSignal(double x) {

				printStar((int) x);

			}

		});
		
	}

	private static void printStar(int x) {

		for (int i = 0; i < x; i++) {
			System.out.print("*");
		}
		System.out.println();

	}
}
