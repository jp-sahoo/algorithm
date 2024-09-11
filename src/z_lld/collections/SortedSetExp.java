package z_lld.collections;

import java.util.*;

public class SortedSetExp<T extends Integer> implements ISortedSet<T>{
    Set<T> set = null;
    Deque<T> deque = null;

    public SortedSetExp() {
        set = new HashSet<>();
        deque = new LinkedList<>();
    }

    @Override
    public void add(T e) {
        set.add(e);
        deque.add(e);
    }

    @Override
    public boolean contains(T e) {
        return false;
    }

    @Override
    public void remove(T e) {
        set.remove(e);
        deque.remove(e);
    }

    @Override
    public Iterator<T> iterator() {
        return deque.iterator();
    }

    @Override
    public ISortedSet<T> subSet(T from, T to) {
        return null;
    }
}
