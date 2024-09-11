package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNodeQuery {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer a : queries) {
            Integer[] tmp = new Integer[2];
            tmp[0] = -1;
            tmp[1] = -1;
            findAns(root, a, tmp);
            ans.add(Arrays.asList(tmp));
        }
        return ans;
    }

    TreeNode binarySearch(TreeNode root, Integer a) {
        if(root != null) {
            if(root.val == a) return root;
            if(root.val < a) {
                return binarySearch(root.left, a);
            } else {
                return binarySearch(root.right, a);
            }
        }
        return null;
    }
    void findAns(TreeNode root, Integer a, Integer[] tmp) {
        if (root != null) {
            findAns(root.left, a, tmp);
            if (root.val <= a) {
                tmp[0] = root.val;
            } else {
                tmp[1] = root.val;
                return;
            }
            findAns(root.right, a, tmp);
        }
    }

    public class TreeNode {
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
