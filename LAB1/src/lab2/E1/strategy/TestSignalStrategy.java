package lab2.E1.strategy;

public class TestSignalStrategy {
	public static void main(String[] args) throws InterruptedException {
		SignalWindow window = new SignalWindow();
		Signal signal = new Signal(window.getTextArea());
		Thread.sleep(2000);
		signal.setSampler(new SinusSampler(3, 0.1));
	}
	
}