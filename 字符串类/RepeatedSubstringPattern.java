package stringclass;

public class RepeatedSubstringPattern {
	// leetcode 159 simple 2022/4/22
	// 判断一个字符串是否由重复的子字符串构成，可以使用移位操作，最多以为n - 1次
	// 时间复杂度与空间复杂度太高了
	public boolean repeatedSubstringPattern1(String s) {
		if (s == null || s.length() < 1) {
			return false;
		}
		int len = s.length();
		String str = s;
		while(len > 1) {
			str = str.charAt(s.length() - 1) + str.substring(0, s.length() - 1);
			if(str.equals(s)) {
				return true;
			}
			len--;
		}
		return false;
    }
	
	// 对暴力解法进行优化，将两个s字符串拼接在一起str，与s进行比较，查看s是否是拼接后字符串的字串
	// 由于s必然是str的子串，所以去掉str的首尾字符，再查看子串关系
	public boolean repeatedSubstringPattern(String s) {
		String str = s + s;
		return str.substring(1 , str.length() - 1).contains(s);
	}
}
