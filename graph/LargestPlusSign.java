package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestPlusSign {
    // leetcode 764 medium 2022/11/9
    // 使用暴力法解决
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        // 将grid数组创建出来，且令mine元素为1
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // 若当前是矿坑，则continue
                    continue;
                }
                int min;// 用于剪枝
                int left = 1;
                while (i - left >= 0 && grid[i - left][j] != 1){
                    left++;
                }
                min = left;
                int right = 1;
                while (i + right < n && right < min && grid[i + right][j] != 1) {
                    right++;
                }
                min = Math.min(min,right);
                int up = 1;
                while(j - up >= 0 && up < min && grid[i][j - up] != 1){
                    up++;
                }
                min = Math.min(min,up);
                int down = 1;
                while(j + down < n && up < min && grid[i][j + down] != 1) {
                    down++;
                }
                int k = Math.min(min,up);
                ans = Math.max(ans,k);
            }
        }
        return ans;
    }

    public int orderOfLargestPlusSign1(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> banned = new HashSet<Integer>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* left */
            for (int j = 0; j < n; j++) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            /* right */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* up */
            for (int j = 0; j < n; j++) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            /* down */
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }
        return ans;
    }
}
