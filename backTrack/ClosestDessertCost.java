package backTrack;

public class ClosestDessertCost {
    // leetcode 1774 medium 2022/12/4
    // 首先想到暴力回溯法
    int ans = Integer.MAX_VALUE;
    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        for (int x : baseCosts) {
            dfs(0, x, target, toppingCosts);

        }
        return ans;
    }

    private void dfs(int x, int sum, int target, int[] toppingCosts) {
        int a = Math.abs(target - sum),b = Math.abs(target - ans);
        if (a < b) {
            ans = sum;
        }
        if (a == b && sum < ans) {
            ans = sum;
        }
        if (sum > target){
            return;
        }
        for (int i = x; i < toppingCosts.length; i++) {
            dfs(i + 1,sum + toppingCosts[i],target,toppingCosts);
            dfs(i + 1,sum + 2 * toppingCosts[i],target,toppingCosts);
        }
    }

    //动态规划
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        boolean[] dp = new boolean[target + 5];
        int ans = Integer.MAX_VALUE;
        // 对于每个基料必须选一个，那么对于大于target的基料就直接判断就可以了，如过小于target，那么就作为dp数组的初始状态。
        for (int x : baseCosts) {
            if (x > target) {
                ans = Math.min(ans,x);
            }else {
                dp[x] = true;
            }
        }
        for (int x : toppingCosts) {
            for (int i = 0; i < 2; i++) {
                for (int j = target; j >= 0; j--) {
                    if (dp[j] && j + x > target){
                        ans = Math.min(ans,j + x);// 计算大于的情况
                    }
                }
            }
        }
        for (int i = 0; i <= ans - target && i <= target; i++) {
            if (dp[target - i]){
                return target - i;
            }
        }
        return ans;
    }
}
