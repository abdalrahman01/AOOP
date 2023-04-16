package lab2.E1.ObserverAndStrategy;



public class TestSignal {
	public static void main(String[] args) throws InterruptedException {
		SignalWindow sw = new SignalWindow();
		Signal s = new Signal();
		s.addSignalObserver(new StarObserver());
		s.addSignalObserver(sw);
		Thread.sleep(4000);
		s.setSampler(new SinusSampler(0, 0.1));
		Thread.sleep(4000);
		s.setSampler(new CosinSampler(0, 0.1));
		
	}
}
