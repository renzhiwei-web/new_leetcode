package graph;

public class ProjectionAreaOf3DShapes {
	// leetcode 883 simple 2022/4/26
	// 模拟即可，俯视图简单，但是左视图与主视图需要查询最大面积
    public int projectionArea(int[][] grid) {
    	int ans1 = 0,ans2 = 0,ans3 = 0;//分别为俯视图，左视图，主视图
    	int n = grid.length;
    	for(int i = 0;i < n;i++) {
    		int a = 0, b = 0;
    		for(int j = 0;j < n;j++) {
    			if (grid[i][j] > 0) {
					ans1++;//俯视图的面积，只有当前单元格中有方格则自增
				}
    			a = Math.max(a, grid[i][j]);//左视图平面的投影面积等于网格上每一行最大数值之和；
    			b = Math.max(b, grid[j][i]);//主视图平面的投影面积等于网格上每一列最大数值之和
    		}
    		ans2 += a;
    		ans3 += b;
    	}
    	return ans1 + ans2 + ans3;
    }
}
