package stringclass;

public class LongestUncommonSubsequenceI {
	// leetcode 521 simple 2022/4/30
	// 脑筋急转弯的题目，容易陷入求子序列的陷阱中
	// 仔细思考，若两字符串相同，则双方无特殊子序列，若两字符串不同，则长度较长的那个字符串是特殊子序列
    public int findLUSlength(String a, String b) {
    	return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
