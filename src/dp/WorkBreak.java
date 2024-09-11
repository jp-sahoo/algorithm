package dp;

import java.util.List;

/**
 * https://leetcode.com/problems/word-break/
 */
public class WorkBreak {
    public static void main(String[] args) {

//        boolean ok = new dp.WorkBreak().wordBreak("leetcode", Arrays.asList("leet", "code"));
//        System.out.println(ok);
        System.out.println("okfine".substring(0,1));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] re = new boolean[s.length() + 1];
        re[0] = true;
        for(int i = 1 ; i <= s.length(); i++) {
            for(int j = 0 ; j < i; j++) {
                if(re[j] && wordDict.contains(s.substring(j, i))) {
                    System.out.println("finally");
                    re[i] = true;
                }
                System.out.println("i " + i + " re[i] " + re[i] + " j " + j +  " re[j] " + re[j] + " substring " + s.substring(j, i) );
            }
        }
        return re[s.length()];
    }
}
