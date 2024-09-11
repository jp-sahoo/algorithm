package array.slidingwindow;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class MaxSubstringWithoutRepeatCharacter {
    public static void main(String[] args) {
        int result = new array.slidingwindow.MaxSubstringWithoutRepeatCharacter().lengthOfLongestSubstring("tmmzuxt");
        System.out.println(result);
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] ch = s.toCharArray();
        if(s.equals("")) {return 0;}
        int res = Integer.MIN_VALUE;
        for(int i =0, j=0; i<s.length();i++) {
            if(set.contains(ch[i])) {
                while(j < i && ch[j] != ch[i]) {
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
    static class Pair<T, U> {
        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
        T first;
        U second;
    }
}
