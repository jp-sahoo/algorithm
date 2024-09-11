package array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumMultiplication {
    public static void main(String[] args) {
//        new HashSet<>(Arrays.asList(1, 2, 3));
        System.out.println(Stream.of('a', 'b', 'c').map(Object::toString).collect(Collectors.joining()));
//        int result = new array.MaximumMultiplication().multiply(new int[]{2,3,-2,4});
//        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
//        sortedMap.put(10,1);
//        sortedMap.put(9,2);
//        sortedMap.put(8,3);
//        sortedMap.forEach((k, v)-> System.out.println(k + " " + v));
//        System.out.println(result);
    }
    private int multiply(int[] arr) {
        int maxTillHere = arr[0];
        int minTillHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(arr[i] * maxTillHere, arr[i] * minTillHere));

            minTillHere = Math.min(arr[i], Math.min(arr[i] * maxTillHere, arr[i] * minTillHere));
            maxTillHere = temp;
            maxSoFar = Math.max(maxSoFar, maxTillHere);
        }
        return maxSoFar;
    }

}
