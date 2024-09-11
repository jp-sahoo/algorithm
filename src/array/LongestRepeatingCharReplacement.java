package array;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 */
public class LongestRepeatingCharReplacement {
    public static void main(String[] args) {

        int ans = new LongestRepeatingCharReplacement().characterReplacement("AABABBA", 1);
        System.out.println("answer " + ans);
//        Stack<String> stack = new Stack<>();

//        final String KEY_DELIMITER = "|";
//        String key = "";
//        LocalDateTime localDateTime = LocalDateTime.parse("2024-02-27T11:45:27");
//
//
//
//        String local_date = localDateTime.toLocalDate().toString();
//        key+= local_date;
//        key+= "12";
//        key+= "30";
//        key+= "0";
//
//        String[] key_elements =
//                key.split("[" + KEY_DELIMITER  + "]",-1);

//        System.out.println(Arrays.toString(key_elements));
//        System.out.println(key_elements[0]);
//        System.out.println(key_elements[1]);
//        System.out.println(key_elements[2]);
//        System.out.println(key_elements[3]);
//        System.out.println(key_elements[4]);
//        Collections.sort(new LinkedList<String>());
//        int[] i = {1, 2};
//        System.out.println(i);
//        List<okay> a = new ArrayList<>();
//        a.add(new okay(1));
//        System.out.println(a.get(0).a);
//        exe(a);
//        System.out.println(a.get(1).a);
//        new HashMap<>().hashCode();
    }

    static void exe(List<okay> a) {
        a.add(new okay(2));
    }
    static class okay {
        int a;

        public okay(int a) {
            this.a = a;
        }
    }

//    public int[] characterReplacement(String s, int k) {
//        return new int[]{1, 2};
//    }
    public int characterReplacement(String s, int k) {
        if(s == null || s.isEmpty()) return 0;
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(o -> o.second)));

        int max = Integer.MIN_VALUE;
        Map<Character, Pair<Character, Integer>> map = new HashMap();
        for(int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.putIfAbsent(c, new Pair(c, 0));
            Pair<Character, Integer> p = map.get(c);
            p.second++;
            pq.remove(p);
            pq.add(p);
            if(!isValid(i, j, pq, k)) {
                while(i <= j && !isValid(i, j, pq, k)) {
                    i++;
                    char ci = s.charAt(i);
                    Pair<Character, Integer> p1 = map.get(ci);
                    pq.remove(p1);
                    if(--p1.second == 0) {
                        map.remove(p1.first);
                    } else {
                        pq.add(p1);
                    }
                }
//                max = Math.max(max, j - i + 1);
            } else {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    private boolean isValid(int i, int j, PriorityQueue<Pair<Character, Integer>> pq, int k) {
        System.out.println("peek jp" + pq.peek().first + " " + pq.peek().second);
        pq.forEach(a -> System.out.print(a.first + " "+ a.second));
        return (j - i + 1 - pq.peek().second) <= k;
    }

    static class Pair<T, U> {
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
        T first;
        U second;
    }
}
