package array;

import java.util.ArrayList;
import java.util.List;

public class Shift2dGrid {
	// leetcode1260 simple 2022/7/20
	// 仔细观察题目，将原二维数组，转成一维数组，通过一维数组向右平移后，再转成二维数组，
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    	int m = grid.length;
    	int n = grid[0].length;
    	int[][] ans = new int[m][n];
    	for(int i = 0,total = m * n;i < m;i++) {
    		for(int j = 0;j < n;j++) {
    			int next = (i * n + j + k) % total;
    			ans[next / n][next % n] = grid[i][j];
    		}
    	}
    	List<List<Integer>> res = new ArrayList<>();
    	for(int i = 0;i < m;i++) {
    		List<Integer> temp = new ArrayList<>();
    		for(int j = 0;j < n;j++) {
    			temp.add(ans[i][j]);
    		}
    		res.add(temp);
    	}
    	return res;
    }
}
