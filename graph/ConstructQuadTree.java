package graph;

public class ConstructQuadTree {
	// leetcode 427 medium 2022/4/29
	// 由于正方形的长度是2的幂，所以矩阵是肯定可以被四等分的
	// 整个矩形，可以用两个坐标来唯一表示，左上角坐标，与右下角坐标
	// 暴力法，通过深度优先递归的遍历当前矩阵中的元素是否都是1或0，
	// 若元素相同，则直接返回根节点，若不相同，通过均分成四等份，构成四个子节点，返回根节点
	public Node construct1(int[][] grid) {
        return dfs1(grid,0,0,grid.length - 1,grid.length - 1);
    }

	private Node dfs1(int[][] grid,int a, int b, int c, int d) {
		boolean ok = true;
		int t = grid[a][b];
		for(int i = a;i <= c && ok;i++) {
			for(int j = b;j <= d && ok;j++) {
				if (grid[i][j] != t) {
					ok = false;
				}
			}
		}
		if (ok) {
			return new Node(t == 1,true);
		}
		Node root = new Node(t== 1, false);
		int dx = c - a + 1;
		int dy = d - b + 1;
		root.topLeft = dfs1(grid,a, b, a + dx / 2 - 1, b + dy / 2 - 1);
		root.topRight = dfs1(grid,a, b + dy / 2, a + dx / 2 - 1, d);
		root.bottomLeft = dfs1(grid,a + dx / 2, b, c, b + dy / 2 - 1);
		root.bottomRight = dfs1(grid,a + dx / 2, b + dy / 2, c, d);
		return root;
	}
	// 使用二维数组前缀和
	public Node construct(int[][] grid) {
		int n = grid.length;
		int[][] pre = new int[n + 1][n + 1];
		for(int i = 1;i <= n;i++) {
			for(int j = 1;j <= n;j++) {
				pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + grid[i - 1][j - 1];
			}
		}
		return dfs(grid,pre, 0, 0, n, n);
	}

	private Node dfs(int[][] grid, int[][] pre, int a, int b, int c, int d) {
		int total = getSum(pre,a,b,c,d);
		if (total == 0) {//若当前矩阵和为0，说明所有元素都是0
			return new Node(false, true);
		}
		int dx = c - a;
		int dy = d - b;
		if (total == (dx) * (dy)) {//若当前矩阵和与矩阵面积相同，则说明所有元素都是1
			return new Node(true, true);
		}
		Node root = new Node(true, false);
		root.topLeft = dfs(grid,pre,a, b,(a + c) / 2 , (b + d) / 2);
		root.topRight = dfs(grid,pre,a, (b + d) / 2, (a + c) / 2, d);
		root.bottomLeft = dfs(grid,pre,(a + c) / 2, b, c, (b + d) / 2);
		root.bottomRight = dfs(grid,pre,(a + c) / 2, (b + d)/ 2, c, d);
		return root;
	}

	private int getSum(int[][] pre, int a, int b, int c, int d) {
		return pre[c][d] - pre[c][b] - pre[a][d] + pre[a][b];
	}
}
