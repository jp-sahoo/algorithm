/**
 * Given an array, determine the longest increasing subsequence
 * Use dynamic programming
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] ar) {
        int[] arr = {1, 10, 5, 4, 3, 6, 12, 9};
        System.out.println(lis(arr));
    }

    private static int lis(int[] arr) {
        //Helper array to store length of LIS
        //res[i] has length of LIS of sub array arr[0...i]
        int[] res = new int[arr.length];

        //All individual element can be considered as an increasing subsequence of length 1
        for (int i = 0; i < arr.length; i++) {
            res[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                //res[i] is max(res[0]...res[j]) for all j (0 < j < i)
                if (arr[j] < arr[i] && res[i] < res[j] + 1) {
                    res[i] = res[j] + 1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
