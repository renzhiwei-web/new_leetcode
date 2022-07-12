package array;

public class CellsWithOddValuesInAMatrix {
	// leetcode 1252 simple 2022/7/12
	// ���������뵽ʹ��ģ��ķ�ʽ���н��⣬���ǲ�����ռ临�Ӷ�Ҫ��
	// ģ��ռ䣬������������������������¼�������ӵĴ���
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
    			// �ж���������ż���Ŀ�ݷ���
    			if (((rows[i] + cols[j]) & 1) != 0) {
					ans++;
				}
    		}
    	}
    	return ans;
    }
    
    // ���������������Ż���Ҫ������е�ĳ��������������Ҫ�����������������ֻ��һ������
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
