package stringclass;


public class RemoveOutermostParentheses {
	// leetcode 1021 simple 2022/5/28
	// 提供了除使用栈以外的新思路
    public String removeOuterParentheses(String s) {
    	char[] ss = s.toCharArray();
    	int len = ss.length;
    	StringBuilder ans = new StringBuilder();
    	for(int i = 0,score = 0;i < len;) {
    		int j = i;
    		// 当score为0时，说明一个有效的括号字符串已经遍历完成
    		while(i == j || score != 0) {
    			// 将(记为1，将)记为-1
    			score += ss[j++] == '(' ? 1 : -1;
    		}
    		// 删掉外层括号，即将[i + 1,j - 1)加入答案
    		ans.append(s.substring(i + 1, j - 1));
    		i = j;
			score = 0;
    	}
    	return ans.toString();
    }
}
