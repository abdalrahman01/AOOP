package lab2.E1.ObserverAndStrategy;

public class SinusSampler implements Sampler {

	private double t, dt;

	public SinusSampler(double start, double deltaT) {
		t = start;
		dt = deltaT;
	}

	public double read() {

		double x = t;
		t += dt;

		return (2 + Math.sin(x)) * 30;
	}

}
