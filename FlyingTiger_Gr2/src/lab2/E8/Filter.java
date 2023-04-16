package lab2.E8;

import java.util.*;

public abstract class Filter {

    public abstract boolean accept(String x);
    

    public  String[] filter(String[] a) {
        List<String> filterThelist = new ArrayList<String>();
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            if (accept(s)) {
                filterThelist.add(s);
            }
        }
        String[] ArrayFiltering = new String[filterThelist.size()];
        return filterThelist.toArray(ArrayFiltering);
    }

    
    
    
}

