package array;

import javafx.util.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxPathSum {
    public static void main(String[] args) {

//        int result = new array.MaxPathSum().maxPathSum(new TreeNode(0));
//        System.out.println(result);
        Double f = Double.parseDouble("8:05");
        System.out.println(f);
        Queue<Integer> q = new LinkedList();
        Deque<Integer> dq = new LinkedList<>();
//        dq.

//        q.
//        Stack<String> s = new Stack<>();
        PriorityQueue<TreeNode> pr = new PriorityQueue<>(2, Collections.reverseOrder(Comparator.comparingInt(a -> a.val + (a.left != null ? 1 : 0))));
        Iterator<TreeNode> i = pr.iterator();
//        while(i.hasNext())
        LinkedList<TreeNode> list = new LinkedList<>();
//        list.remove
        Map<Integer, Integer> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println(k + " " + v));

//        list.listIterator()
//        list.sort(Comparator.comparingInt(a -> a.val));

//        PriorityQueue<Integer> pr1 = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.sort(args, Comparator.reverseOrder());
        Arrays.sort(args, (a, b) -> a.length() - b.length());
//        Arrays.stream(args).collect(Collectors.groupingBy(a -> a.))
//        new HashMap<>().forEach((_, v) -> );
//        Arrays.fill();

//        pr.stream().map(a -> a.val< 5)
//        pr.stream().mapToInt(a -> a.val).toArray();
        pr.offer(new TreeNode(10));
        pr.add(new TreeNode(11));
        pr.add(new TreeNode(12));
//        Deque<Integer> dq = new ArrayDeque<>();
//        LinkedList<Integer> list = new LinkedList<>();


        PriorityQueue<TreeNode> pw = new PriorityQueue<>(2, Comparator.comparingInt(a -> a.val));
//        Vector<Integer> vector = new Vector<>();
        NavigableSet<Integer> sortedSet = new TreeSet<>((a,b) -> b - a);
//        sortedSet.higher()
//        sortedSet.
//        sortedSe
//        sortedSet
        LinkedHashMap<Integer, Integer> concurrent = new LinkedHashMap<>();
//        concurrent.

//        sortedSet.
//        sortedSe

//        sortedSet
//        NavigableSet
        NavigableMap<Integer, List<Integer>> sortedMap = new TreeMap<>();


//        sortedMap.
        sortedMap.higherEntry(1);
        sortedMap.lowerEntry(1);
        NavigableMap<Integer, List<Integer>> ok = sortedMap.subMap(1, true, 2, true);
//        ok.
        List<Integer>  temp = sortedMap.putIfAbsent(1, new LinkedList<>());
        List<Integer>[] adj = new LinkedList[1];
        Arrays.stream(adj).forEach(a -> System.out.println(Arrays.toString(a.stream().mapToInt(b->b).toArray())));
//        Arrays.stream(adj).forEach();
//        adj[0].get
        temp.clear();
        temp.add(1);
//        Integer p = 0;
//        sortedSet.stream().mapToInt(a -> a.hashCode())
//        SortedMap<Integer, Integer> sortedMapP = sortedMap.tailMap(2);


        HashMap<Integer, Integer> sortedMap2 = new LinkedHashMap<>();



//        int a = ~5;
//        int b = 6 >> 6;
//        int c = 40 >> 3;
//        1010; 101
//        110
//        System.out.println(a + " " + b + " " + c);
//        dq.rem
    }

    private static int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root) {
        int left = 0;
        int right = 0;
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }

        if (root.left != null)
            left = maxSum(root.left);
        if (root.right != null)
            right = maxSum(root.right);
        max = Math.max(left + right + root.val, max);
        return Math.max(left, right) + root.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
