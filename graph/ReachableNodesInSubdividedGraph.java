package graph;

import java.util.*;

public class ReachableNodesInSubdividedGraph {
    // leetcode 882 hard 2022/11/26
    // 考察从0开始可以达到的最多细分点，
    // 首先使用迪杰斯特拉算法，得到0点到其他任一点的距离
    // 再通过使用最短距离来得出到达的细分点
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] grid = new ArrayList[n];
        Arrays.setAll(grid,e -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cnt = edge[2];
            grid[u].add(new int[]{v,cnt + 1});
            grid[v].add(new int[]{u,cnt + 1});
        }
        int[] dist = dijkstra(grid,0);
        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves){
                ans++;
            }
        }
        for(int[] e : edges){
            int u = e[0],v = e[1],cnt = e[2];
            int a = Math.max(maxMoves - dist[u],0);
            int b = Math.max(maxMoves - dist[v],0);
            ans += Math.min(a + b,cnt);
        }
        return ans;
    }

    private int[] dijkstra(List<int[]>[] grid, int start) {
        int[] dist = new int[grid.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        // 以到0点的最短距离为顺序进行排序
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{start,0});
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0],d = p[1];
            if (d > dist[x]){
                continue;
            }
            for (var e : grid[x]) {
                int y = e[0];
                int newDist = d + e[1];
                if (newDist < dist[y]){
                    dist[y] = newDist;
                    queue.offer(new int[]{y,newDist});
                }
            }
        }
        return dist;
    }
}
