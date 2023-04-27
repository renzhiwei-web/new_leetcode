package dp;

import java.util.List;

public class RodCutting {
    public int rodCunt(int[] profit,List<Integer> list){
        int len = profit.length;
        int[] dp = new int[len + 1];
        int[] rec = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = profit[i - 1];
            rec[i] = i;
            for (int j = 1; j < i; j++) {
                int temp = profit[j - 1] + dp[i - j];
                if (dp[i] < temp) {
                    dp[i] = temp;
                    rec[i] = j;
                }
            }
        }
        int i = len;
        while (i > 0) {
            list.add(rec[i]);
            i -= rec[i];
        }
        return dp[len];
    }
}
