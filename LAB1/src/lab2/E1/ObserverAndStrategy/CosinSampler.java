package lab2.E1.ObserverAndStrategy;

public class CosinSampler implements Sampler {

	private double t, dt;

	public CosinSampler(double start, double deltaT) {
		t = start;
		dt = deltaT;
	}

	public double read() {

		double x = t;
		t += dt;

		return (2 + Math.cos(x)) * 30;
	}

}
