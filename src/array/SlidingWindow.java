package array;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {
    public static void main(String[] args) {
//        int length = new SlidingWindow().lengthOfLongestSubstring("jyiotiprakash");
        String ans = new SlidingWindow().sliding("jyhoaiaprhalrqkash", "aaah");
        System.out.println(ans);
    }

    /**
     * maintain a set to check if that element is in visited set
     * maintain 2 pointer, keep increasing 1 pointer put them into visited set
     * if found anything already visited i.e duplicate found keep increasing other pointer until you find that element
     * then move 1 step ahead and keep going
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        Set<Character> set = new HashSet();
        char[] ch = s.toCharArray();
        int res = Integer.MIN_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(ch[i])) {
                while (j < i && ch[j] != ch[i]) {
                    set.remove(ch[j]);
                    j++;
                }
                j++;
            } else {
                set.add(ch[i]);
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public String  sliding(String s, String contains) {
        if (s.equals("")) {
            return "";
        }
        Set<Character> set = new HashSet();
        char[] ch = s.toCharArray();
        int res = Integer.MIN_VALUE;
        String ans = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(ch[i])) {
                while (j < i && ch[j] != ch[i]) {
                    set.remove(ch[j]);
                    j++;
                }
                j++;
            } else {
                set.add(ch[i]);
            }
            if(isValid(set, contains)) {
                if(res < i - j +1) {
                    res = i - j +1;
                    ans = s.substring(j, i +1);
                }
//                res = Math.max(res, i - j + 1);
            }

        }
        return ans;
    }

    private boolean isValid(Set<Character> set, String contains) {
        for(char c: contains.toCharArray()) {
            if(!set.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
