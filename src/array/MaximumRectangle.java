package array;

import java.util.*;

class MaximumRectangle {
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','0'},{'1','0','1','1','1'},{'1','0','0','1','0'}};
        int res = new MaximumRectangle().maximalRectangle(arr);
//        List<Integer> res = new array.MaximumRectangle().twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2,3}, new int[]{3});
        System.out.println(res);
    }

//    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
//        List<Integer> res = new ArrayList();
//        Set<Integer> s1 = new HashSet();
//        Set<Integer> s2 = new HashSet();
//        Set<Integer> s3 = new HashSet();
//        for(int n: nums1) {
//            s1.add(n);
//        }
//        for(int n: nums2) {
//            s2.add(n);
//        }
//        for(int n: nums3) {
//            s3.add(n);
//        }
//        Iterator<Integer> i1 = s1.iterator();
//        while(i1.hasNext()) {
//            int n = i1.next();
//            if(s2.contains(n) || s3.contains(n)) {
//                s2.remove(n);
//                s3.remove(n);
//                res.add(n);
//            }
//        }
//
//        s2.forEach(n -> {
//            if(s3.contains(n)) {
//                s2.remove(n);
//                s3.remove(n);
//                res.add(n);
//            }
//        });
//        return res;
//    }

    public int maximalRectangle(char[][] matrix) {
        int[][] input = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                if(i==0) {
                    input[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if(matrix[i][j] == '1') {
                    input[i][j] =  input[i-1][j] + 1;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<input.length; i++) {
            ans = Math.max(ans, getMax(input[i]));
        }
        return ans;
    }

    private int getMax(int[] ar) {
        System.out.println(Arrays.toString(ar));
        int area = ar[0];
        Stack<Integer> s = new Stack();
        int i = 0;
        while(i<ar.length) {
            if(s.isEmpty() || ar[s.peek()] <= ar[i]) {
                s.push(i++);
                System.out.println(s);
            } else {
                while(!s.isEmpty() && ar[s.peek()] > ar[i]) {
                    int top = s.pop();
                    area = s.isEmpty()? Math.max(area, i * ar[top]) : Math.max(area, (i - s.peek() - 1) * ar[top]);
                }
                System.out.println("Post popping " + s);
                System.out.println("ares " + area);
            }
        }
        System.out.println("Finishing " + s);
        System.out.println("ares " + area);
        while(!s.isEmpty()) {
            int top = s.pop();
            area = s.isEmpty()? Math.max(area, i * ar[top]) : Math.max(area, (i - s.peek() - 1) * ar[top]);
        }
        return area;
    }
}
