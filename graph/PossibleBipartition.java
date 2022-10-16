package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {
	// leetcode 886 medium 2022/10/16
	// 利用图论的方法进行遍历搜索，对各个节点进行染色
    public boolean possibleBipartition1(int n, int[][] dislikes) {
    	// 分组情况，当color[i] = 0表示未分组，=1表示第一组，=2表示第二组
    	int[] color = new int[n + 1];
    	// 使用数组存储无向图
    	List<Integer>[] g = new List[n + 1];
    	for(int i = 0;i <= n;i++) {
    		g[i] = new ArrayList<>();
    	}
    	for(int[] p : dislikes) {
    		g[p[0]].add(p[1]);
    		g[p[1]].add(p[0]);
    	}
    	// 
    	for(int i = 1;i <=n;i++) {
    		if (color[i] == 0 && !dfs(i,1,color,g)) {
				return false;
			}
    	}
    	return true;
    }

    /**
     * 
     * @param curNode 当前遍历节点
     * @param nowColor 设置当前节点的颜色
     * @param color
     * @param g
     * @return
     */
	private boolean dfs(int curNode, int nowColor, int[] color, List<Integer>[] g) {
		color[curNode] = nowColor;
		// 遍历当前节点不喜欢的节点
		for (int nextNode : g[curNode]) {
			// 如果nextnode已经被分组，如果 nextNode 的颜色与curNode 的颜色相同，则与题意不符
			if (color[nextNode] != 0 && color[nextNode] == color[curNode]) {
				return false;
			}
			// 如果nextnode没有被分组，对其进行染色，如果出现不符合题意的，则返回false
			// 3 ^ 1 = 2,3 ^ 2 = 1;
			if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ nowColor, color, g)) {
				return false;
			}
		}
		return true;
	}
	
	// 使用并查集的方法进行解题
	public boolean possibleBipartition(int n, int[][] dislikes) {
		int[] fa = new int[n + 1];
		Arrays.fill(fa, -1);
		List<Integer>[] g = new List[n + 1];
		for (int i = 0;i <= n;i++) {
			g[i] = new ArrayList<>();
		}
		for(int[] p : dislikes) {
			g[p[0]].add(p[1]);
			g[p[1]].add(p[0]);
		}
		
		// 
		for(int i = 1;i <= n;i++) {
			for(int j = 0;j < g[i].size();j++) {
				unit(g[i].get(0), g[i].get(j), fa);
				if (isconnect(i, g[i].get(j), fa)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//
    public void unit(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        if (x == y) {
            return ;
        }
        if (fa[x] < fa[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        fa[x] += fa[y];
        fa[y] = x;
    }

    public boolean isconnect(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        return x == y;
    }

    public int findFa(int x, int[] fa) {
        return fa[x] < 0 ? x : (fa[x] = findFa(fa[x], fa));
    }
}
