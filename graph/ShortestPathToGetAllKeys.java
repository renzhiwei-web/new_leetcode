package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathToGetAllKeys {
    // leetcode 864 hard 2022/11/10
    // 由于是求最短路径，所以使用bfs
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] graph = new char[m][n];
        // 存储起点
        int[] start = new int[2];
        // 存储钥匙/锁的个数
        int k = 0;
        for (int i = 0; i < m; i++) {
            char[] temp = grid[i].toCharArray();
            for (int j = 0; j < n; j++) {
                graph[i][j] = temp[j];
                if (temp[j] == '@'){
                    start[0] = i;
                    start[1] = j;
                } else if (Character.isLowerCase(temp[j])) {
                    k++;
                }
            }
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0],start[1],0});
        // 第三个维度表示当前拥有的钥匙
        boolean[][][] visit = new boolean[m][n][1<<k];
        visit[start[0]][start[1]][0] = true;
        int ans = 0;
        while (!queue.isEmpty()){
            for (int t = queue.size();t > 0;--t){
                int[] p = queue.poll();
                int i = p[0],j = p[1],state = p[2];
                // 找到所有钥匙，返回当前步数
                if (state == (1 << k) - 1) {
                    return ans;
                }
                // 往四个方向搜索
                for (int h = 0; h < dirs.length; h++) {
                    int x = i + dirs[h][0];
                    int y = j + dirs[h][1];
                    // 在边界范围内
                    if (x >= 0 && x < m && y >= 0 && y < n){
                        char c = graph[x][y];
                        // 如果是墙，或者是锁，但此时没有对应的钥匙，无法通过
                        if (c == '#' || (Character.isUpperCase(c) && ((state >> (c - 'A')) & 1) == 0)){
                            continue;
                        }

                        int nxt = state;
                        // 是钥匙
                        if (Character.isLowerCase(c)){
                            // 更新状态
                            nxt |= 1 << (c - 'a');
                        }
                        // 此状态未访问过，入队
                        if (!visit[x][y][nxt]) {
                            visit[x][y][nxt] = true;
                            queue.offer(new int[]{x,y,nxt});
                        }
                    }

                }
            }
            ans++;
        }
        return -1;
    }
}
