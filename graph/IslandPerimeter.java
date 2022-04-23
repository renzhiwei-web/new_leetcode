package graph;

public class IslandPerimeter {
	//leetcode 463 simple 2022/4/23
	// 很容易想到使用dfs，但是难点是如何计算周长
	// 关于如何计算周长，观察周长的来源，如何相邻的网格是边界或水域，则才有周长
	public int islandPerimeter1(int[][] grid) {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 1) {
					return dfs(grid, r, c);
				}
			}
		}
		return 0;
	}

	private int dfs(int[][] grid, int r, int c) {
		// 从一个岛屿方格走向网格边界，周长加 1
		if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
			return 1;
		}
		// 从一个岛屿方格走向水域方格，周长加 1
		if (grid[r][c] == 0) {
			return 1;
		}
		//走向其他地方，即相邻的岛屿块不加
		// 已经被遍历过
		if (grid[r][c] != 1) {
			return 0;
		}
		grid[r][c] = 2;
		return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
	}
	
	// 利用岛屿与其相邻的岛屿的个数来计算
	// 总周长 = 4 * 土地个数 - 2 * 接壤的个数
	public int islandPerimeter(int[][] grid) {
		int land = 0;
		int border = 0;
		for(int i = 0;i < grid.length;i++) {
			for(int j = 0;j < grid[0].length;j++) {
				if(grid[i][j] == 1) {
					land++;
					if(i < grid.length - 1 && grid[i + 1][j] == 1) {// 上下方向只取一个方向，避免重复
						border++;
					}
					if (j < grid[0].length - 1 && grid[i][j + 1] == 1) { // 同理，左右方向也只取一个方向
						border++;
					}
				}
			}
		}
		return 4 * land - 2 *border;
	}
}
