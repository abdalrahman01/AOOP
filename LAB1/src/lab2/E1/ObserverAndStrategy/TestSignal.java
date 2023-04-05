package lab2.E1.ObserverAndStrategy;

import lab2.E1.strategy.Sampler;
import lab2.E1.strategy.SinusSampler;

public class TestSignal {
	public static void main(String[] args) throws InterruptedException {
		SignalWindow sw = new SignalWindow();
		Signal s = new Signal();
		s.addSignalObserver(new StarObserver());
		s.addSignalObserver(sw);
		Thread.sleep(2000);
		s.setSampler(new SinusSampler(3, 0.1));
		
	}
}
