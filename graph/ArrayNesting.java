package graph;

public class ArrayNesting {
	// leetcode 565 medium 2022/7/17
	// �������飬�õ�һ������ͼ�������ҵ����Ļ�
    public int arrayNesting1(int[] nums) {
    	int n = nums.length;
    	int ans = 0;
    	boolean[] vis = new boolean[n];
    	for(int i = 0;i < n;i++) {
    		int cnt = 0;
    		while(!vis[i]) {
    			vis[i] = true;
    			i = nums[i];
    			cnt++;
    		}
    		ans = Math.max(ans, cnt);
    	}
    	return ans;
    }
    
    // ԭ�ر�Ƿ�
    public int arrayNesting(int[] nums) {
    	int ans = 0;
    	int n = nums.length;
    	for(int i = 0;i < n;i++) {
    		int cnt = 0;
    		while(nums[i] < n) {
    			int num = nums[i];
    			nums[i] = n;
    			i = num;
    			cnt++;
    		}
    		ans = Math.max(ans, cnt);
    	}
    	return ans;
    }
}
