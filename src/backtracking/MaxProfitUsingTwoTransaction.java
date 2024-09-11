package backtracking;

import java.util.Arrays;

public class MaxProfitUsingTwoTransaction {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 7, 10, 0, 100};
        System.out.println(Arrays.toString(arr));
        int res = new MaxProfitUsingTwoTransaction().maxProfit(arr);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int buyPrice1 = Integer.MAX_VALUE;
        int profit1 = Integer.MIN_VALUE;
        int buyPrice2 = Integer.MAX_VALUE;
        int profit2 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            //first Transaction
            buyPrice1 = Math.min(buyPrice1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - buyPrice1);

            //Second Transaction
            buyPrice2 = Math.min(buyPrice2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - buyPrice2);
            System.out.println("buyPrice1: " + buyPrice1 + " profit1: " + profit1 + " buyPrice2: " + buyPrice2 + " profit2: " + profit2);
        }

        return profit2;
    }
}
