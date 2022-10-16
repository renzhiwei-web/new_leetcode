package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {
	// leetcode 886 medium 2022/10/16
	// ����ͼ�۵ķ������б����������Ը����ڵ����Ⱦɫ
    public boolean possibleBipartition1(int n, int[][] dislikes) {
    	// �����������color[i] = 0��ʾδ���飬=1��ʾ��һ�飬=2��ʾ�ڶ���
    	int[] color = new int[n + 1];
    	// ʹ������洢����ͼ
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
     * @param curNode ��ǰ�����ڵ�
     * @param nowColor ���õ�ǰ�ڵ����ɫ
     * @param color
     * @param g
     * @return
     */
	private boolean dfs(int curNode, int nowColor, int[] color, List<Integer>[] g) {
		color[curNode] = nowColor;
		// ������ǰ�ڵ㲻ϲ���Ľڵ�
		for (int nextNode : g[curNode]) {
			// ���nextnode�Ѿ������飬��� nextNode ����ɫ��curNode ����ɫ��ͬ���������ⲻ��
			if (color[nextNode] != 0 && color[nextNode] == color[curNode]) {
				return false;
			}
			// ���nextnodeû�б����飬�������Ⱦɫ��������ֲ���������ģ��򷵻�false
			// 3 ^ 1 = 2,3 ^ 2 = 1;
			if (color[nextNode] == 0 && !dfs(nextNode, 3 ^ nowColor, color, g)) {
				return false;
			}
		}
		return true;
	}
	
	// ʹ�ò��鼯�ķ������н���
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
