package Exercise15;

public class Circle implements Comparable<Circle> {
	private double x, y;
	private double r;

	public Circle(double cx, double cy, double rad) {
		x = cx;
		y = cy;
		r = rad;
	}

	public String toString() {
		return "Circle with radius " + r;
	}

	public double area() {
		return Math.PI * r * r;
	}

	public static void main(String[] args) {
		Circle a = new Circle(0, 0, 10);
		Circle b = new Circle(1, 2, 20);
		System.out.println(a.compareTo(b));
		System.out.println(Max.max(a,b));
	}

	public int compareTo(Circle o) {
		if(r > o.r) return 1;
		if(r < o.r) return -1;
		return 0;
		// return (int)(r-o.r);
	}
}