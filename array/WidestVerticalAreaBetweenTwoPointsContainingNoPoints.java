package array;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    // leetcode1637 medium 2023/3/30
    // 简单模拟即可
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points,((o1, o2) -> {
            return o1[0] - o2[0];
        }));
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans,points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}
