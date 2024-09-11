package z_lld.collections;

import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        ISortedSet<Integer> i = new SortedSetExp<>();
        i.add(3);
        Iterator<Integer> iterator = i.iterator();
        if(iterator.hasNext()) {
            int q = iterator.next();
            System.out.println();

        }
    }


}
