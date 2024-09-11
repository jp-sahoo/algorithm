package graph.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 1. if you need to print path always do bfs with path not with node
 * 2. create an adjacency map to check who are next of a word
 * 3. do bfs with the path
 *
 */
public class WordLadderTwo {
    public static void main(String[] args) {
        List<List<String>> res = new WordLadderTwo().findLadders("cet", "ism", Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim"));
        res.forEach(System.out::println);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new LinkedList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        Map<String, Set<String>> adj = new HashMap<>();
        adj.putIfAbsent(beginWord, new HashSet<>());
        for (String s : wordList) {
            adj.putIfAbsent(s, new HashSet<>());
            if (isNext(beginWord, s)) {
                adj.get(beginWord).add(s);
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (isNext(wordList.get(i), wordList.get(j))) {
                    adj.get(wordList.get(i)).add(wordList.get(j));
                    adj.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }
        Queue<List<String>> q = new LinkedList<>();
        List<String> init = new LinkedList<>();
        init.add(beginWord);
        q.add(init);
        boolean found = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<String> n = q.poll();
                String curr = n.get(n.size() - 1);
                System.out.println("current " + curr);
                if (curr.equals(endWord)) {
                    found = true;
                    ans.add(n);
                }
                for (String p : adj.get(curr)) {
                    if (!n.contains(p)) {
                        List<String> newList = new LinkedList<>(n);
                        newList.add(p);
                        q.add(newList);
                    }
                }
            }
            if (found) {
                break;
            }
        }
        return ans;
    }

    boolean isNext(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)) {
                if(count == 0) {
                    count++;
                } else if(count == 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
