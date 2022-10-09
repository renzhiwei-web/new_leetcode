package divideandconquer;

public class ScoreOfParentheses {
	// leetcode 856 medium 2022/10/9
	// 括号问题，可以想到分治或者栈
	// 分治算法
    public int scoreOfParentheses(String s) {
    	if (s.length() == 2) {
			return 1;
		}
    	// bal记录当前括号是否是闭合的
    	int bal = 0, n = s.length(),len = 0;
    	for(int i = 0;i < n;i++) {
    		bal += (s.charAt(i) == '(' ? 1 : -1);
    		if (bal == 0) {// 如果当前的括号是闭合的，则结束循环，分解问题
				len = i + 1;
				break;
			}
    	}
    	// (A) 的分数是2 * A
    	if (len == n) {
			return 2 * scoreOfParentheses(s.substring(1, n - 1));
		}else {
			// () + ()
			return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
		}
    }
    
    // 栈 + 计数算法。由题意可得，只有()才产生分数，而()产生的分数取决于()的深度，单一的()深度为0
    public int scoreOfParentheses1(String s) {
    	if (s.length() == 2) {
			return 1;
		}
    	int n = s.length();
    	int d = 0;//深度
    	int ans = 0;
    	for(int i = 0;i < n;i++) {
    		if (s.charAt(i) == '(') {
				d++;
			}else {
				d--;
				if (s.charAt(i - 1) == '(') {
					ans += 1 << d;
				}
			}
    	}
    	return ans;
    }
}
