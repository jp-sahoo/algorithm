package array;

import java.util.Arrays;

public class AddOne {
    public static void main(String[] args) {
        int[] output = new AddOne().addOne(new int[]{1, 9, 9});
        System.out.println(Arrays.toString(output));
        char[] s = new char[2];
        new String(s);
    }
    private int[] addOne(int[] input) {
        int carry = 1;
        for (int i = input.length -1 ; i >= 0 ; i--) {
            if(input[i] + carry > 9) {
                input[i] = (input[i] + carry) % 10;
            } else {
                input[i] += carry;
                carry = 0;
                break;
            }
        }


        if(carry != 0) {
            int[] newArray = new int[input.length + 1];
            newArray[0] = carry;
            System.arraycopy(input, 0, newArray, 1, input.length);
            return newArray;
        } else {
            return input;
        }
    }
}
