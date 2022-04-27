package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PacificAtlanticWaterFlow {
	// leetcode 417 medium 2022/4/27
	// 采用逆向思维，通过从两片海洋开始搜索遍历到岛屿的格子，取两者交集
	// 广度优先搜索遍历，找到两个答案矩阵res，所有能够进入队列的格子均能够与海域联通
    public List<List<Integer>> pacificAtlantic1(int[][] heights) {
    	int m = heights.length,n = heights[0].length;
    	Deque<int[]> pDeque = new ArrayDeque<>(),aDeque = new ArrayDeque<>();
    	boolean[][] pRes = new boolean[m][n],aRes = new boolean[m][n];
    	for(int i = 0;i < m;i++) {
    		for(int j = 0;j < n;j++) {
    			if (i == 0 || j == 0) {
					pRes[i][j] = true;
					pDeque.addLast(new int[] {i,j});
				}
    			if (i == m - 1 || j == n - 1) {
					aRes[i][j] = true;
					aDeque.addLast(new int[] {i,j});
				}
    		}
    	}
    	bfs(heights,pDeque,pRes);
    	bfs(heights,aDeque,aRes);
    	List<List<Integer>> ans = new ArrayList<>();
    	for(int i = 0;i < m;i++) {
    		for(int j = 0;j < n;j++) {
    			if (pRes[i][j] && aRes[i][j]) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					ans.add(list);
				}
    		}
    	}
    	return ans;
    }
    
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
	private void bfs(int[][] heights, Deque<int[]> deque, boolean[][] res) {
		// TODO Auto-generated method stub
		while(!deque.isEmpty()) {
			int[] info = deque.pollFirst();
			int x = info[0];
			int y = info[1];
			int t = heights[x][y];
			for(int[] di : dirs) {
				int nx = x + di[0],ny = y + di[1];
				if (nx < 0 || nx >= heights.length || ny < 0 || ny >=heights[0].length) {
					continue;
				}
				if (res[nx][ny] || heights[nx][ny] < t) {
					continue;
				}
				deque.add(new int[] {nx,ny});
				res[nx][ny] = true;
			}
		}
	}
	
	// 深度优先搜索遍历
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length,n = heights[0].length;
		boolean[][] pRes = new boolean[m][n],aRes = new boolean[m][n];
		for(int i = 0;i < m;i++) {
			for(int j = 0;j < n;j++) {
				if (i == 0 || j == 0) {
					if (!pRes[i][j]) {
						dfs(heights,pRes,i,j);
					}
				}
				if (i == m - 1 || j == n - 1) {
					if (!aRes[i][j]) {
						dfs(heights,aRes,i,j);
					}
				}
			}
		}
		List<List<Integer>> ans = new ArrayList<>();
    	for(int i = 0;i < m;i++) {
    		for(int j = 0;j < n;j++) {
    			if (pRes[i][j] && aRes[i][j]) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					ans.add(list);
				}
    		}
    	}
    	return ans;
	}
	
	private void dfs(int[][] heights, boolean[][] res, int x, int y) {
		res[x][y] = true;
		for(int[] di : dirs) {
			int nx = x + di[0],ny = y + di[1];
			if (nx < 0 || nx >= heights.length || ny < 0 || ny >=heights[0].length) {
				continue;
			}
			if (res[nx][ny] || heights[nx][ny] < heights[x][y]) {
				continue;
			}
			dfs(heights, res, nx, ny);
		}
	}
}
