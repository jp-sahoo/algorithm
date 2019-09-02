import java.util.Arrays;

public class LongestPalindrom {
    public static void main(String[] args) {
        String s = "prakashsak";
        int result = getLongest(s.toCharArray());
        System.out.println(result);
    }

    private static int getLongest(char[] ch) {
        //res[i][j] = true if i..j is a palindrome
        boolean[][] res = new boolean[ch.length][ch.length];
        //We need to initialize the base case for length 1 and 2 as those are two basic type of palindromes
        //all string with length 1 are palindrome
        for (int i = 0; i < ch.length; i++) {
            res[i][i] = true;
        }

        int start = 0;
        int length = 1;
        int maxLength = 1;
        //all string with length 2 are palindrome if both characters are same
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                start = i;
                length = 2;
                maxLength = 2;
                res[i][i + 1] = true;
            }
        }

        //check for other lengths
        for (int k = 3; k <= ch.length; k++) {
            for (int i = 0; i < ch.length - k + 1; i++) {
                int j = i + k - 1;
                if (res[i + 1][j - 1] && ch[i] == ch[j]) {
                    res[i][j] = true;
                    start = i;
                    length = k;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        //print the longest palindrome
        System.out.println(Arrays.toString(Arrays.copyOfRange(ch, start, start + maxLength)));
        return maxLength;
    }
}
