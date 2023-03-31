package Exercise15;

import java.util.Comparator;

public class Max {

	/*
	 * public interface Comparable<T>{ int compareTo(T other); }
	 */

	public static <T extends Comparable<T>> T max(T a, T b) {
		if(a.compareTo(b) > 0) 
			return a;
		return  b;
	}

	public static <T> T max(T a, T b, Comparator<T> c) {
		if(c.compare(a,b) > 0) 
			return a;
		return  b;
	}

	public static <T extends Comparable<T>> T max(T[] a) {
		assert a.length > 0;
		T max = a[0];
		for(T e : a)
			if(e.compareTo(max)>0)
				max = e;
		return max;
	}

	public static void main(String[] args) {
		// System.out.println(max(args[0], args[1]));
		System.out.println(max(2, 3));
		System.out.println(max("four", "two"));
		//System.out.println(max(args));
		Integer[] x = { 3, 2, 4, 1 };
		System.out.println(max(x));
	}
}