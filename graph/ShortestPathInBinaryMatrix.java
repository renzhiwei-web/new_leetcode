package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    // leetcode 1091 medium 2023/5/26
    // 求矩阵中路径的长度，使用bfs容易解决
    private static int[] direct= {-1,0,1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0){
            return -1;
        }
        int n = grid.length;
        if (n == 1){
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        // 已经走过的单元格标记为路径长度
        grid[0][0] = 1;
        while (!queue.isEmpty()){
            int num = queue.size();
            for (int k = 0; k < num; k++) {
                var cur = queue.poll();
                for (int i : direct) {
                    int x = cur[0] + i;
                    for (int j : direct) {
                        int y = cur[1] + j;
                        if (x < 0 || y < 0 || x > n - 1 || y > n - 1){
                            continue;
                        }
                        if (grid[x][y] == 0){
                            if (x == n - 1 && y == n - 1){
                                return grid[cur[0]][cur[1]] + 1;
                            }
                            grid[x][y] = grid[cur[0]][cur[1]] + 1;
                            queue.offer(new int[]{x,y});
                        }
                    }
                }
            }

        }

        return -1;
    }
}
