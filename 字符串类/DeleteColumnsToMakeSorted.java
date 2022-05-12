package stringclass;

public class DeleteColumnsToMakeSorted {
	// leetcode 944 simple 2022/5/12
	// 简单模拟即可
    public int minDeletionSize(String[] strs) {
    	int len = strs.length;
    	int n = strs[0].length();
    	int ans = 0;
    	for(int i = 0;i < n;i++) {
    		char lastCh = strs[0].charAt(i);
    		for(int j = 1;j < len;j++) {
    			if (lastCh > strs[j].charAt(i)) {
					ans++;
					break;
				}else {
					lastCh = strs[j].charAt(i);
				}
    		}
    	}
    	return ans;
    }
}
