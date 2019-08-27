/**
 * Given an array, determine if it can reach the end of the array(n+1 th position) starting from first position.
 * Condition : It can jump max up to array[i] position when at ith position
 * Uses Dynamic programming
 */
public class TowerHopper {
    public static void main(String[] args) {
        int[] arr = {4, -3, 0, 0, 1, 2, 0, 1, 2, 0};
        boolean result = isHoppable(arr);
        System.out.println(result);
    }

    private static boolean isHoppable(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return false;
        }
        boolean[] res = new boolean[arr.length];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                for (int j = arr[i]; j > 0; j--) {
                    //If the current length arr[i] from ith position(i+arr[i]) exceeding the array length, then res[i] is true
                    //Or if any position it can jump from the current ith position is true then res[i] is true
                    if (i + j >= n || res[i + j] == true) {
                        res[i] = true;
                        break;
                    }
                }
            } else {
                //If the current element is zero, it can't jump
                res[i] = false;
            }
        }
        return res[0];
    }
}
