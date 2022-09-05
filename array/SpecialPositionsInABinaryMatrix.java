package array;


public class SpecialPositionsInABinaryMatrix {
	// leetcode 1582 simple 2022/9/4
	// ¼òµ¥Ä£Äâ¼´¿É
    public int numSpecial(int[][] mat) {
    	int n = mat.length, m = mat[0].length, ans = 0;
        int[] r = new int[n], c = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) r[i] += mat[i][j];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) c[i] += mat[j][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) ans++;
            }
        }
        return ans;
    }
}
