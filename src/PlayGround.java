import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayGround {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0; i < Math.pow(2, nums.length); i++) {
            ans.add(getData(nums, i));
        }
//        Arrays.stream(nums).sum();
        return ans;
    }

    List<Integer> getData(int[] nums, int set) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 1; i <= nums.length; i++) {
            if((set & (1<< i-1)) !=0) {
                ans.add(nums[i-1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println((int)Math.floor(Math.random() * 10 + 50));
//        System.out.println(calculateHCF(12, 16));
//        System.out.println((int)Math.pow(3, 3));
        List<List<Integer>> ans = new PlayGround().subsets(new int[]{1, 2, 3});
        ans.forEach(System.out::println);
//        String[] q = "2001:0db8:85a3:0:0:8A2E:0370:7334:".split(":");
//        int[] buffer = new int[] {1, 2, 3, 5, 10, 15, 20};
//        System.out.println(findClosestElements(buffer, 4, 11));
        int[][] exp = new int[][] {{1, 2, 3, 5, 10, 15, 20}, {1, 2, 3, 5, 10, 15, 20}};
        Arrays.sort(exp, (a, b)-> (a[0] == b[0] ? (a[1] == b[1]? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]));
//        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder(Comparator.comparingInt(a -> buffer[a])));
        SortedSet<Integer> hs = new TreeSet<>(Collections.reverseOrder(Comparator.comparingInt(a -> a)));
//        String ok = Arrays.stream(buffer).mapToObj(String::valueOf).collect(Collectors.joining("->"));
//        System.out.println(ok);
//
//
//
//        System.out.println(Arrays.toString(q));
//        NavigableSet<Integer> navigableSet = new TreeSet<>();
//        Iterator<Integer> i = navigableSet.descendingIterator();
//        List<String> queue = new LinkedList();
////        queue.con
//        Set<Integer[]> set = new HashSet();
//        set.stream().filter(a-> a[0] != 0).collect(Collectors.toList());
//        set.removeIf(a -> a[0] > 3);
//
//
//
//        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(b -> b.freq)));
////        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.reverseOrder(b -> b[0]));
////        /new HashMap<>()
//        IntStream.range(0, 2).forEach(p -> queue.add(pq.poll().s));
//        Map<String, Integer> map = new HashMap();
//        map.forEach((p, b) -> System.out.println(p));
////        queue.se
////        map.remove()
//
////        new TreeSet<String>(map.keySet());queue.subList()
//        List<Integer> array = new ArrayList<>();
////        array.a
////        Arrays.binarySearch()
//        int[][] envelopes = new int[1][1];
//        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
//        PriorityQueue<Integer> hell = new PriorityQueue<Integer>((a, b) -> nums[b.intValue()] - nums[b.intValue()]);

    }
    class Pair{
        String s;
        int freq;
        Pair(String s) {
            this.s = s;
        }
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = Arrays.binarySearch(arr, x);
        int actualPost = pos < 0? pos == -1 ? 0: -pos - 2 : pos;
        System.out.println(pos + " " + actualPost);
            int from = actualPost == 0 || actualPost - k/2 < 0? 0 : (actualPost + k/2 > arr.length -1 ? arr.length - k : actualPost - k/2);
        System.out.println(from + " " + (from + k));
        Arrays.binarySearch(arr, 1);
        return Arrays.stream(Arrays.copyOfRange(arr, from, from + k)).boxed().collect(Collectors.toList());
    }

    public void wiggleSort(int[] nums) {
        boolean flag = false;
//        Arrays.sort(nums, getComparator(flag));
    }
    Comparator getComparator(boolean flag) {
        if(flag) {
            flag = false;
            return null;
        } else {
            flag = true;
            return Collections.reverseOrder();
        }
    }

    boolean isNext(String a, String b) {
        boolean f = true;
        for(int i = 0; i< a.length(); i++) {
            boolean b1 = a.charAt(i) != b.charAt(i);
            if(f && b1) {
                f = false;
            } else if(b1) {
                return false;
            }
        }
        return true;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        SortedSet<Integer> hs = new TreeSet<>((a, b) -> nums[b] == nums[a] ? b - a : nums[b] - nums[a]);
        for(int i = 0; i< k; i++) {
            hs.add(i);
        }
        ans[0] = nums[hs.first()];
        hs.forEach(a->System.out.print(a));
        System.out.println();

        // hs.remove(0);
        for(int i = k; i< nums.length; i++) {
            System.out.println("inserting " + i);
            hs.add(i);
            hs.remove(i-k);
            hs.forEach(a->System.out.print(a));
            // System.out.println();
            ans[i-k + 1] = nums[hs.first()];
        }
        return ans;
    }
    class Account {
        double balance;

        void withdraw(double amount){
            balance -= amount;
        }

        void deposit(double amount){
            balance += amount;
        }
    }
    public static int calculateHCF(int a, int b) {
        while (b != 0) {
            System.out.println(a + "  " + b);
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
