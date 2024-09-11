package z_lld.collections;

import java.util.Iterator;

public interface ISortedSet<T extends Integer> {
    void add(T e);
    boolean contains(T e);
    void remove(T e);
    Iterator<T> iterator();
    ISortedSet<T> subSet(T from, T to);
}
