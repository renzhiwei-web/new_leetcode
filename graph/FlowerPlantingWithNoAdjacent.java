package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerPlantingWithNoAdjacent {
    // leetcode 1042 medium 2023/4/15
    // 使用广度优先算法+枚举的方式进行解题
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] grid = new List[n];
        Arrays.setAll(grid,k -> new ArrayList<>());
        for (var path : paths) {
            int x = path[0] - 1;
            int y = path[1] - 1;
            grid[x].add(y);
            grid[y].add(x);
        }
        int[] ans = new int[n];
        boolean[] used = new boolean[5];
        for (int x = 0; x < n; x++) {
            Arrays.fill(used,false);
            for (int y : grid[x]) {// 若y没有被遍历过，则used[0]=false;
                used[ans[y]] = true;
            }
            for (int c = 1;c < 5;++c) {
                if (!used[c]) {
                    ans[x] = c;
                    break;
                }
            }
        }
        return ans;
    }
}
