package array;

import java.util.ArrayList;
import java.util.List;

public class Shift2dGrid {
	// leetcode1260 simple 2022/7/20
	// ��ϸ�۲���Ŀ����ԭ��ά���飬ת��һά���飬ͨ��һά��������ƽ�ƺ���ת�ɶ�ά���飬
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
