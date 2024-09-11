package design;

import java.util.NavigableMap;
import java.util.*;

class RangeModule {

    public static void main(String[] args) {
        RangeModule obj = new RangeModule();
        obj.addRange(10, 20);
        obj.removeRange(14, 16);
        System.out.println(obj.queryRange(10, 14));
        System.out.println(obj.queryRange(13, 14));
        System.out.println(obj.queryRange(16, 17));
    }
    NavigableMap<Integer, Integer> map = null;
    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        remove(left, right);
        map.put(left, right);
        print();
    }

    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> ceil  = map.floorEntry(left);
        Integer start = ceil!= null && ceil.getValue() > left ? ceil.getKey() : (map.containsKey(left) ? left: null);
        Integer prev = null;
        while(start != null && start < right) {
            prev = start;
            start = map.get(start);
        }
        if(start == null) {
            return false;
        }
        return map.get(prev) > right;
    }

    public void removeRange(int left, int right) {
        remove(left, right);
        print();
    }

    private void remove(int left, int right) {
        Map.Entry<Integer, Integer> ceil  = map.floorEntry(left);
        Map.Entry<Integer, Integer> low = map.lowerEntry(right);
        if(low!= null && low.getValue()>right) {
            map.put(right, low.getValue());
        }
        NavigableMap<Integer, Integer> subMap = map.subMap(left, true, right, false);
        if(!subMap.isEmpty()) {
            subMap.clear();
        }
        if(ceil != null && ceil.getValue()>left) {
            map.put(ceil.getKey(), left);
        }
    }

    void print() {
        map.forEach((k, v) -> System.out.print(k + "-" + v + " "));
        System.out.println();
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */