package stringclass;

public class MaximumScoreAfterSplittingAString {
	// leetcode 1422 simple 2022/8/14
	// 简单进行模拟即可
    public int maxScore(String s) {
    	int len = s.length();
    	int sumZero = 0;
    	char[] ss = s.toCharArray();
    	for(char ch : ss) {
    		if (ch == '0') {
				sumZero++;
			}
    	}
    	int sumOne = len - sumZero;
    	int curZero = 0;
    	int curOne = 0;
    	int ans = 0;
    	for(int i = 0;i < ss.length - 1;i++) {
    		if (ss[i] == '0') {
				curZero++;
			}else {
				curOne++;
			}
    		int tempRes = curZero + sumOne - curOne;
    		ans = Math.max(ans, tempRes);
    	}
    	return ans;
    }
}
