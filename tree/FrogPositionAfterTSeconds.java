package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogPositionAfterTSeconds {
    private double ans = 0.;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] g = new ArrayList[n + 1];
        Arrays.setAll(g,e -> new ArrayList<>());
        g[1].add(0);
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(g,target,1,0,t,1);
        return ans;
    }

    private boolean dfs(List<Integer>[] g, int target, int x, int fa, int leftT, long prod) {
        // t 秒后必须在 target（恰好到达，或者 target 是叶子停在原地）
        if (x == target && (leftT == 0 || g[x].size() == 1)) {
            ans = 1.0 / prod;
            return true;
        }
        if (x == target || leftT == 0) return false;
        // 因为是树的结构，所以不用担心会往父节点跳
        for (int y : g[x])  // 遍历 x 的儿子 y
            if (y != fa && dfs(g, target, y, x, leftT - 1, prod * (g[x].size() - 1)))
                return true; // 找到 target 就不再递归了
        return false; // 未找到 target
    }
}
