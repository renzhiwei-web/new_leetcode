package graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumMovesToReachTargetWithRotations {
    private static int[][] dirs = {{1,0,0},{0,1,0},{0,0,1}};
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        // 三维表示蛇的状态，0表示水平，1表示竖直
        boolean[][][] vis = new boolean[n][n][2];
        List<int[]> q = new ArrayList<>();
        vis[0][0][0] = true;
        q.add(new int[]{0,0,0});
        for (int step = 1; !q.isEmpty(); step++) {
            var temp = q;
            q = new ArrayList<>();
            for (var t : temp) {
                for (var d : dirs) {
                    int x = t[0] + d[0];
                    int y = t[1] + d[1];
                    int s = t[2] ^ d[2];
                    int x2 = x + s;
                    int y2 = y + (s ^ 1);// x2,y2表示蛇头的位置
                    if (x2 < n && y2 < n && !vis[x][y][s] && grid[x][y] == 0 && grid[x2][y2] == 0
                    && (d[2] == 0 || grid[x + 1][y + 1] == 0)){
                        if (x == n - 1 && y == n - 2){
                            return step;
                        }
                        vis[x][y][s] = true;
                        q.add(new int[]{x,y,s});
                    }
                }
            }
        }
        return -1;
    }
}
