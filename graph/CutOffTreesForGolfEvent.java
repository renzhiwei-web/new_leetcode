package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class CutOffTreesForGolfEvent {
	// leetcode 675 hard 2022/5/23
	// 由于需要从低到高砍掉所有的树，意味着首先要遍历所有的树，并将所有的树进行按高度排序，利用bfs进行逐层遍历
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int cutOffTree(List<List<Integer>> forest) {
    	List<int[]> trees = new ArrayList<>();
    	int row = forest.size(),col = forest.get(0).size();
    	for(int i = 0;i < row;i++) {
    		for(int j = 0;j < col;j++) {
    			if (forest.get(i).get(j) > 1) {
					trees.add(new int[]{i,j});
				}
    		}
    	}
    	Collections.sort(trees,(a,b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));
    	
    	int cx = 0;
    	int cy = 0;
    	int ans = 0;
    	for(int i = 0;i < trees.size();i++) {
    		int steps = bfs(forest,cx,cy,trees.get(i)[0],trees.get(i)[1]);
    		if (steps == -1) {
				return -1;
			}
    		ans += steps;
    		cx = trees.get(i)[0];
    		cy = trees.get(i)[1];
    	}
    	return ans;
    }
	private int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
		if (sx == tx && sy == ty) {
			return 0;
		}
		
		int row = forest.size();
		int col = forest.get(0).size();
		int step = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[row][col];
		queue.offer(new int[] {sx,sy});
		visited[sx][sy] = true;
		while (!queue.isEmpty()) {
			step++;
			int sz = queue.size();
			for(int i = 0;i < sz;i++) {
				int[] cell = queue.poll();
				int cx = cell[0],cy = cell[1];
				for(int j = 0;j < 4;j++) {
					int nx = cx + dirs[j][0];
					int ny = cy + dirs[j][1];
					if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
						if(!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
							if (nx == tx && ny == ty) {
								return step;
							}
							queue.offer(new int[] {nx,ny});
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
		return -1;
	}
}