package array;

public class FindNearestPointThatHasTheSameXOrYCoordinate {
    // leetcode 1779 simple 2022/12/1
    // 简单模拟
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (minDistance > distance){
                    minDistance = distance;
                    ans = i;
                }

            }
        }
        return ans;
    }
}
