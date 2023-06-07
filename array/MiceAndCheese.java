package array;

import java.util.Arrays;

public class MiceAndCheese {
    // leetcode 2611 2023/6/7
    // 采用贪心算法，先将所有的等分分于第二只老鼠，然后再将k个等分差分于第一只老鼠
    // 开始被题意迷惑，实际上第一只老鼠恰好吃掉k块奶酪与第二只老鼠吃的顺序无关
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int ans = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++) {
            ans += diff[n - 1 - i];
        }
        return ans;
    }
}
