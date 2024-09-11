package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/car-pooling/
 * trips[i] = [numPassengersi, fromi, toi]
 * ek rasta bana do with array, jahan jahan chadna hai wahan add karo number, jahan utarna hai wahan minus karo
 */
public class CarPooling {
    public static void main(String[] args) {
        boolean res = new CarPooling().carPooling(new int[][]{{2,1,5}, {3,3,7}}, 3);
        System.out.println(res);
    }
    public boolean carPoolingOne(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        Set<int[]> set = new HashSet<>();
        int cur = 0;
        for (int[] trip : trips) {
            set.add(new int[]{trip[0], trip[1], trip[2]});
            cur += trip[0];
            final int start = trip[1];
            List<int[]> list = set.stream().filter(a -> a[2] <= start).collect(Collectors.toList());
            if (!list.isEmpty()) {
                for (int[] a : list) {
                    cur -= a[0];
                }
                set.removeIf(a -> a[2] <= start);
            }
            if (cur > capacity) return false;
            if (set.isEmpty()) {
                cur = 0;
            }
        }
        return true;
    }

    public boolean carPoolingTwo(int[][] trips, int capacity) {
        int[][] temp = new int[trips.length * 2][3];
        for(int i = 0, j = 0; i< trips.length; i++) {
            temp[j][0] = trips[i][0];
            temp[j][1] = trips[i][1];
            temp[j][2] = 0;
            j++;
            temp[j][0] = trips[i][0];
            temp[j][1] = trips[i][2];
            temp[j][2] = 1;
            j++;
        }
        Arrays.sort(temp, (a, b) -> a[1] == b[1] ? b[2] - a[2] : a[1] - b[1]);
        int cur = 0;
        for(int[] a: temp) {
            if(a[2] == 0) {
                cur+=a[0];
            } else {
                cur-=a[0];
            }
            if(cur > capacity) return false;
        }
        return true;
    }

    /**
     * ek rasta bana do with array, jahan jahan chadna hai wahan add karo number, jahan utarna hai wahan minus karo
     *
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for(int[] a: trips) {
            max = Math.max(max, a[2]);
        }
        int[] temp = new int[max+1];
        for(int[] a: trips) {
            temp[a[1]] += a[0];
            temp[a[2]] -= a[0];
        }
        int cur = 0;
        for(int a: temp) {
            cur+=a;
            if(cur > capacity) {
                return false;
            }
        }
        return true;
    }
}
