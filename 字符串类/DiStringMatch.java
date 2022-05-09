package stringclass;

public class DiStringMatch {
	// leetcode 942 simple 2022/5/9
	// 首先容易想到贪心法
    public int[] diStringMatch(String s) {
    	int n = s.length();
    	int[] ans = new int[n + 1];
    	int left = 0,right = n;
    	char[] cs = s.toCharArray();
    	for(int i = 0;i < n;i++) {
    		if (cs[i] == 'I') {
				ans[i] = left;
				left++;
			}else {
				ans[i] = right;
				right--;
			}
    	}
    	ans[n] = left;
    	return ans;
    }
}
