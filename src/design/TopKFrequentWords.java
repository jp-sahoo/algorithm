package design;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> ans = new ArrayList<>(map.keySet());
//        for(String s: map.keySet()) {
//            ans.add(s);
//        }
        ans.sort((a, b) -> Objects.equals(map.get(a), map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        return ans.subList(0, k);
    }

}
