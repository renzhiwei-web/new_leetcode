package graph;

import java.util.Arrays;

public class CheckingExistenceOfEdgeLengthLimitedPaths {
    // leetcode 1697 hard 2022/12/14
    // 由于判断每条边是否小于对应的limit，所以将所有小于limit的边权加入到并查集中
    // 再通过并查集判断是否联通
    private int[] p;
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        Arrays.sort(edgeList,(a,b) -> a[2] - b[2]);
        Integer[] qid = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qid[i] = i;
        }
        Arrays.sort(qid,(i,j) -> queries[i][2] - queries[j][2]);
        int j = 0;
        for (int i : qid) {
            int a = queries[i][0];
            int b = queries[i][1];
            int limit = queries[i][2];
            while(j < edgeList.length && edgeList[j][2] < limit){
                int u = edgeList[j][0];
                int v = edgeList[j][1];
                p[find(u)] = find(v);
                j++;
            }
            ans[i] = find(a) == find(b);
        }
        return ans;

    }

    private int find(int x) {
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
