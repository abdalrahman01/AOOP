import java.util.*;

public class CheckLengthFilter implements Filter {
    public boolean accept(String x) {
        return x.length() <= 3;
    }

    public static String[] filter(String[] a, Filter f) {
        List<String> filterThelist = new ArrayList<String>();
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            if (f.accept(s)) {
                filterThelist.add(s);
            }
        }
        String[] ArrayFiltering = new String[filterThelist.size()];
        return filterThelist.toArray(ArrayFiltering);
    }

    public static void main(String[] args) {
        String[] array = { "banana", "cat", "dog", "egg", "fish", "Morad", "Abd" };
        CheckLengthFilter checklengthFilter = new CheckLengthFilter();
        String[] filteredArr = filter(array, checklengthFilter);
        System.out.println(Arrays.toString(filteredArr));
    }
}

interface Filter {
    boolean accept(String x);
}
