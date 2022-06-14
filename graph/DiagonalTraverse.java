package graph;

public class DiagonalTraverse {
	// leetcode 498 medium 2022/6/14
	// 对题目进行模拟，找到规律即可
    public int[] findDiagonalOrder(int[][] mat) {
    	int n = mat.length, m = mat[0].length, cnt = n * m;
        int[] ans = new int[cnt];
        int x = 0, y = 0, dir = 1, idx = 0;
        while (idx != cnt) {
            ans[idx++] = mat[x][y];
            int nx = x, ny = y;
            if (dir == 1) {//往右上角遍历
                nx = x - 1; ny = y + 1;
            } else {//往左下角遍历
                nx = x + 1; ny = y - 1;
            }
            if (idx < cnt && (nx < 0 || nx >= n || ny < 0 || ny >= m)) {
                if (dir == 1) {
                    nx = y + 1 < m ? x : x + 1;
                    ny = y + 1 < m ? y + 1 : y;
                } else {
                    nx = x + 1 < n ? x + 1 : x;
                    ny = x + 1 < n ? y : y + 1;
                }
                dir *= -1;
            }
            x = nx; y = ny;
        }
        return ans;
    }
}
