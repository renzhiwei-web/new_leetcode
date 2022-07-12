package array;

public class CellsWithOddValuesInAMatrix {
	// leetcode 1252 simple 2022/7/12
	// 首先容易想到使用模拟的方式进行解题，但是不满足空间复杂度要求
	// 模拟空间，可以用行数组与列数组来记录矩阵被增加的次数
    public int oddCells1(int m, int n, int[][] indices) {
    	int[] rows = new int[m];
    	int[] cols = new int[n];
    	
    	for(int[] index : indices) {
    		rows[index[0]]++;
    		cols[index[1]]++;
    	}
    	
    	int ans = 0;
    	for(int i = 0;i < m;i++) {
    		for(int j = 0;j < n;j++) {
    			// 判断奇数或者偶数的快捷方法
    			if (((rows[i] + cols[j]) & 1) != 0) {
					ans++;
				}
    		}
    	}
    	return ans;
    }
    
    // 对上述方法进行优化，要想矩阵中的某个数是奇数，则要求，行数组或列数组中只有一个奇数
    public int oddCells(int m, int n, int[][] indices) {
    	int[] rows = new int[m];
    	int[] cols = new int[n];
    	
    	for(int[] index : indices) {
    		rows[index[0]]++;
    		cols[index[1]]++;
    	}
    	
    	int oddx = 0,oddy = 0;
    	for(int i = 0;i < m;i++) {
    		if ((rows[i] & 1) != 0) {
				oddx++;
			}
    	}
    	
    	for(int i = 0;i < n;i++) {
    		if ((cols[i] & 1) != 0) {
				oddy++;
			}
    	}
    	return oddx * (n - oddy) + (m - oddx) * oddy;
    }
}
