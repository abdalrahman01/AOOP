package lab2.E1.observer;


public class TestSignalObserver {
	public static void main(String[] args) {
		SignalWindow sw = new SignalWindow();
		

		Signal s = new Signal();
		s.addSignalObserver(new StartObserver());
		s.addSignalObserver(sw);
		
	}

}
