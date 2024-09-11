package dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class MaxProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Triplet[] tr = new Triplet[startTime.length];
        int[] ans = new int[startTime.length];
        for(int i = 0; i<startTime.length; i++) {
            tr[i] = new Triplet(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(tr, Comparator.comparingInt(a->a.b));
        ans[0] = tr[0].c;
        for(int i = 1; i<startTime.length; i++) {
            int non = -1;
            for(int j = i-1; j>=0; j--) {
                if(tr[j].b <=tr[i].a) {
                    non = j;
                    break;
                }
            }
            ans[i] = Math.max(ans[i-1], tr[i].c + (non == -1 ? 0 : ans[non]));
        }
        return ans[startTime.length - 1];
    }

    class Triplet{
        @Override
        public String toString() {
            return "[" + a + "," + b + "," + c + "]";
        }
        int a;
        int b;
        int c;
        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}