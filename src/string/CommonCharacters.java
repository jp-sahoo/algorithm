package string;

import java.util.*;
import java.util.stream.IntStream;

/**
 *
 */
public class CommonCharacters {
    public static void main(String[] args) {
        List<String> ans = new CommonCharacters().commonChars(new String[]{"bella","label","roller"});
        ans.forEach(System.out::println);
    }
    public List<String> commonChars(String[] A) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] cnt = new int[26];
            str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
            IntStream.range(0, 26).forEach(i ->  count[i] = Math.min(cnt[i], count[i])); // update minimum frequency.
        }
        List<String> ans = new ArrayList<>();
        IntStream.range('a', 'z' + 1).forEach(c ->  ans.addAll(Collections.nCopies(count[c - 'a'], "" + (char)c)));
//        IntStream.range(0, 26).forEach(c -> ans.addAll(Collections.nCopies(count[c], ""+(char)c)));
        return ans;
    }
}
