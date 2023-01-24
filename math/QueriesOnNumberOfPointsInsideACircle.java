package math;

public class QueriesOnNumberOfPointsInsideACircle {
    // leetcode 1828 medium 2023/1/24
    // 简单模拟
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int ansi = 0;
            int x = queries[i][0],y = queries[i][1],r = queries[i][2];
            int r2 = r * r;
            for (int[] point : points) {
                int distance = (point[0] - x) * (point[0] - x) + (point[1] - y) * (point[1] - y);
                if (distance <= r2) {
                    ansi++;
                }
            }
            ans[i] = ansi;
        }
        return ans;
    }
}
