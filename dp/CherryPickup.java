package dp;

public class CherryPickup {
	
	static int N = 55,INF = Integer.MIN_VALUE;// N 为本题范围，因题目有负值的格子，定义INF作为dp数组初始化用
	// 定义dp数组用于记录结果，由题意，第二次遍历等价于与第一次相同的规则再走一遍，故总共有2N次结果。
    // 进而可以将问题转换为，两个点从左上角同时开始走，最后都走到右下角的最大得分。
    // dp[k][i1][i2]为当前已走了k步（k 为所在格子的横纵坐标之和），第一个点在i1行，第二个点在i2行的最大得分，最终答案为dp[2n][n][n]。
	static int[][][] f = new int[2 * N][N][N];
    public int cherryPickup(int[][] grid) {
    	int n = grid.length;
    	for(int k = 0;k <= 2 * n;k++ ) {
    		for(int i1 = 0;i1 <= n;i1++) {
    			for(int i2 = 0;i2 <= n;i2++) {
    				f[k][i1][i2] = INF;
    			}
    		}
    	}
    	// dp[2][1][1] 两个点都在左上角的初始状态，都为0，即 dp[2][1][1] = grid[0][0]
    	f[2][1][1] = grid[0][0];
    	// 从k=3开始，第一个点开始运动。
    	for(int k = 3;k <= 2 * n;k++) {
    		 // 两个点都从第一行开始，i1和i2都为1到n。
    		for(int i1 = 1;i1 <= n;i1++) {
    			for(int i2 = 1;i2 <= n;i2++) {
    				// 计算两个点当前所在的列
    				int j1 = k - i1,j2 = k - i2;
    				  // 检查越界
    				if (j1 <= 0 || j1 > n || j2 <= 0 || j2 > n) {
						continue;
					}
    				// 检查两个点所在位置是否有障碍，有的话跳过。
    				int A = grid[i1 - 1][j1 - 1], B = grid[i2 - 1][j2 - 1];
    				if (A == -1 || B == -1) {
						continue;
					}
    				   // 确认两个点同时移动都可行，当前第k步可以从原来的两个点状态的最大值转移过来，由于从行走或从列走都有可能，共有四种状态。
    				int a = f[k - 1][i1 - 1][i2],b = f[k - 1][i1 - 1][i2 - 1];
    				int c = f[k - 1][i1][i2 - 1],d = f[k - 1][i1][i2];
    				int t = Math.max(Math.max(a, b), Math.max(c, d)) + A;
    				// 两个点不重合可以同时累加。
    				if (i1 != i2) {
						t += B;
					}
    				f[k][i1][i2] = t;
    			}
    		}
    	}
    	return f[2 * n][n][n] <= 0 ? 0 : f[2 * n][n][n];
    }
}
