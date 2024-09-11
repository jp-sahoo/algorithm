package tree;

import java.util.Arrays;
import java.util.Stack;

/**
 *                    10
 *                7         15
 *             3     8   12     18
 *                    9           16
 *
 *             3 7 9 10 12 15 18
 */
public class TargetSumInBst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        root.right.right.left = new TreeNode(16);

        new TargetSumInBst().print(root, new int[10], 0);
//        boolean res = new TargetSumInBst().isPossible(root, 34);
//        System.out.println(res);
    }
    void print(TreeNode root, int[] buffer, int depth){
        if(root != null) {
            buffer[depth] = root.val;
            print(root.left, buffer, depth+1);
            if(root.left == null && root.right == null) {
                System.out.println(Arrays.toString(Arrays.copyOf(buffer, depth+1)));
            }
            print(root.right, buffer, depth+2);
        }
    }

    public boolean isPossible(TreeNode root, int k) {
        // Create two stacks. s1 is used for 
        // normal inorder traversal and s2 is 
        // used for reverse inorder traversal 
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();

        // Note the sizes of stacks is MAX_SIZE, 
        // we can find the tree size and fix stack size 
        // as O(Logn) for balanced trees like AVL and Red Black 
        // tree. We have used MAX_SIZE to keep the code simple 

        // done1, val1 and curr1 are used for 
        // normal inorder traversal using s1 
        // done2, val2 and curr2 are used for 
        // reverse inorder traversal using s2 
        boolean done1 = false, done2 = false;
        int val1 = 0, val2 = 0;
        TreeNode curr1 = root, curr2 = root;

        // The loop will break when we either 
        // find a pair or one of the two 
        // traversals is complete 
        while (true)
        {

            // Find next TreeNode in normal Inorder 
            // traversal. See following post 
            // https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/ 
            while (done1 == false)
            {
                if (curr1 != null)
                {
                    s1.push(curr1);
                    curr1 = curr1.left;
                }
                else
                {
                    if (s1.isEmpty())
                        done1 = true;
                    else
                    {
                        curr1 = s1.pop();
                        val1 = curr1.val;
                        curr1 = curr1.right;
                        done1 = true;
                    }
                }
            }

            // Find next TreeNode in REVERSE Inorder traversal. The only 
            // difference between above and below loop is, in below loop 
            // right subtree is traversed before left subtree 
            while (done2 == false)
            {
                if (curr2 != null)
                {
                    s2.push(curr2);
                    curr2 = curr2.right;
                }
                else {
                    if (s2.isEmpty())
                        done2 = true;
                    else {
                        curr2 = s2.pop();
                        val2 = curr2.val;
                        curr2 = curr2.left;
                        done2 = true;
                    }
                }
            }

            // If we find a pair, then print the pair and return. The first 
            // condition makes sure that two same values are not added 
            if ((val1 != val2) && (val1 + val2) == k)
            {
                System.out.print("Pair Found: " +
                        val1+ "+ " +
                        val2+ " = " +
                        k +"\n");
                return true;
            }

            // If sum of current values is smaller, 
            // then move to next TreeNode in 
            // normal inorder traversal 
            else if ((val1 + val2) < k)
                done1 = false;

                // If sum of current values is greater, 
                // then move to next TreeNode in 
                // reverse inorder traversal 
            else if ((val1 + val2) > k)
                done2 = false;

            // If any of the inorder traversals is 
            // over, then there is no pair 
            // so return false 
            if (val1 >= val2)
                return false;
        }
    }

    private boolean isPossibleBak(TreeNode root, int k) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        TreeNode temp = root;
        while(temp != null) {
            st1.push(temp);
            temp = temp.left;
        }
        temp = root;
        while(temp != null) {
            st2.push(temp);
            temp = temp.right;
        }
        TreeNode left = st1.pop();
        TreeNode right = st2.pop();
        while((left != null && right != null) && (left != right)) {
            System.out.println(left.val + " " + right.val);
            if(left.val + right.val == k) {
                return true;
            } else if(left.val + right.val < k) {
                left = getNextLeft(st1, left);
            } else {
                right = getNextRight(st2, right);
            }
        }
        return false;
    }

    private TreeNode getNextLeft(Stack<TreeNode> st, TreeNode left) {
        TreeNode temp = left;
        if(temp.right != null) {
            temp = temp.right;
            TreeNode prev = null;
            while (temp != null) {
                prev = temp;
                st.push(temp);
                temp = temp.left;
            }
            st.pop();
            return prev;
        } else {
            TreeNode peek = null;
            if(!st.isEmpty()) {
                peek = st.peek();
                st.pop();
            }
            return peek;
        }
    }
    private TreeNode getNextRight(Stack<TreeNode> st, TreeNode right) {
        TreeNode temp = right;
        if(temp.left != null) {
            temp = temp.left;
            TreeNode prev = null;
            while (temp != null) {
                prev = temp;
                st.push(temp);
                temp = temp.right;
            }
            st.pop();
            return prev;
        } else {
            TreeNode peek = null;
            if(!st.isEmpty()){
                peek = st.peek();
                st.pop();
            }
            return peek;
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
