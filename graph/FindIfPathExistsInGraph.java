package graph;

public class FindIfPathExistsInGraph {
    // leetcode 1971 simple 2022/12/19
    // 首先想到使用并查集思想
    int[] p;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            p[find(u)] = find(v);
        }
        return find(source) == find(destination);
    }


    private int find(int x) {
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
