package lab2.E8;

import java.util.Arrays;

public class TestFilter extends Filter{

	@Override
	public boolean accept(String x) {
		return x.length() <= 3;
	}
	
	public static void main(String[] args) {
        String[] array = { "banana", "cat", "dog", "egg", "fish", "Morad", "Abd", "Ali20", "1"};
        TestFilter filter = new TestFilter();
        String[] filteredArr = filter.filter(array);
        System.out.println(Arrays.toString(filteredArr));
    }

}
