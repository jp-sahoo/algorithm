package z_lld;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RankTeamByVotes {
    public static void main(String[] args) {
        String[] arg1 = {"ABC","ACB","ABC","ACB","ACB"};
        String[] arg2 = {"WXYZ","XYZW"};
        String result = new RankTeamByVotes().rankTeams(arg2);
        System.out.println(result);
    }
    public String rankTeams(String[] votes) {
        int[][] tmp = new int[26][votes[0].length()];
//        Arrays.sort(tmp, Comparator.comparingInt(a -> a[0][0]));
        for(int i = 0; i< votes.length; i++) {
            for(int j = 0; j< votes[0].length(); j++) {
                tmp[votes[i].charAt(j) - 'A'][j]++;
            }
        }
        new HashMap<>().replaceAll((k, v) -> v=true);
        Character[] cArr = new Character[votes[0].length()];
        new HashSet().stream().forEach(System.out::println);
        for(int i = 0; i < votes[0].length(); i++) {
            cArr[i] = votes[0].charAt(i);
        }

        Arrays.sort(cArr, (a, b) -> {
            for(int i = 0; i< votes[0].length(); i++) {
                if(tmp[a - 'A'][i] != tmp[b - 'A'][i]) {
                    return tmp[b - 'A'][i] - tmp[a - 'A'][i];
                }
            }
            return a-b;
        });
        return new String(Arrays.stream(cArr).map(a-> a.toString()).collect(Collectors.joining()).toCharArray());
    }
    static class Pair{
        int c;
        char a;
        Pair(char a, int c) {
            this.a = a;
            this.c = c;
        }
    }
}