package Exercise15;

import java.util.*;

public class SCL {

	public static void main(String[] args) {
		assert args.length > 0;
		List<String> cl = Arrays.asList(args);
		// List<Circle> cl = Arrays.asList(new Circle[] {new Circle(0,0,20), new Circle(1,2,10)});
		Collections.sort(cl, new StringComparator());
		// Collections.sort(cl);
		for (Object s : cl) System.out.println(s);
	}
}
