package math;

public class TransformToChessboard {
	// leetcode 782 hard 2022/8/23
	// 数学方式解题
    public int movesToChessboard(int[][] board) {
    	if (!check(board)) {
			return -1;
		}
    	int[] col = new int[board.length];
    	for(int i = 0;i < board.length;i++) {
    		col[i] = board[i][0];
    	}
    	return getSwapCount(board[0]) + getSwapCount(col);
    }

    private int getSwapCount(int[] sentinel) {
		int preNum = 1;
		int errorCnt = 0;
		for(int i : sentinel) {
			// 统计有多少错位
			if (i != preNum) {
				errorCnt++;
			}
			preNum = preNum == 1 ? 0 : 1;
		}
		// 数组是偶数个还是奇数个
		if (sentinel.length % 2 == 0) {
			return Math.min(sentinel.length - errorCnt, errorCnt) / 2;
		}else {
			// 奇数个 取决于1多还是0 多
			if (errorCnt % 2 == 0) {
				return errorCnt / 2;
			}else {
				return (sentinel.length - errorCnt) >> 1;
			}
		}

	}

	// 检查矩阵是否能变成棋盘 分别检查行和列
	private boolean check(int[][] board) {
		return checkFirstRow(board) &&
				checkFirstCol(board) && 
				checkRow(board) &&
				checkCol(board);
 	}

	private boolean checkCol(int[][] board) {
		// 与行检查相同
		int sameCnt = 0;
		int oppositeCnt = 0;
		int[] sentinel = new int[board.length];
		for(int j = 0;j < board.length;j++) {
			sentinel[j] = board[j][0];
		}
		for(int j = 0;j < board.length;j++) {
			if (board[0][j] == sentinel[0]) {
				for(int i = 0;i < sentinel.length;i++) {
					if (sentinel[i] != board[i][j]) {
						return false;
					}
				}
				sameCnt++;
			}else {
				for (int i = 0; i < sentinel.length; i++) {
                    if (sentinel[i] + board[i][j] != 1) {
                        return false;
                    }
                }
                oppositeCnt++;
			}
		}
		return sameCnt == oppositeCnt || Math.abs(sameCnt - oppositeCnt) == 1;
	}

	private boolean checkRow(int[][] board) {
		// 以第一行为基准，其他行或与第一行相等，或与第一行相反
		int[] seninel = board[0];
		int sameCnt = 0;
		int oppositeCnt = 0;
		for(int[] cur : board) {
			// 相同
			if (seninel[0] == cur[0]) {
				for(int i = 0;i < seninel.length;i++) {
					if (seninel[i] != cur[i]) {
						return false;
					}
				}
				sameCnt++;
			}else { // 相反
				for(int i = 0;i < seninel.length;i++) {
					if (seninel[i] + cur[i] != 1) {
						return false;
					}
				}
				oppositeCnt++;
			}
			
		}
		return sameCnt == oppositeCnt || Math.abs(sameCnt - oppositeCnt) == 1;
	}

	private boolean checkFirstCol(int[][] board) {
		int oneCnt = 0;
		int zeroCnt = 0;
		for(int i = 0;i < board.length;i++) {
			if (board[0][i] == 0) {
				zeroCnt++;
			}else {
				oneCnt++;
			}
		}
		return oneCnt == zeroCnt || Math.abs(oneCnt - zeroCnt) == 1;
	}

	private boolean checkFirstRow(int[][] board) {
		int rowOneCnt = 0;
		int rowZeroCnt = 0;
		int[] first = board[0];
		for(int num : first) {
			if (num == 0) {
				rowZeroCnt++;
			}else {
				rowOneCnt++;
			}
		}
		return rowOneCnt == rowZeroCnt || Math.abs(rowOneCnt - rowZeroCnt) == 1;
	}
}
