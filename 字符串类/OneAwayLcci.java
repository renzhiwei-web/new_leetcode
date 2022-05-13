package stringclass;

public class OneAwayLcci {
	// leetcode 2530 medium 2022/5/13
	// 简单模拟即可
	public boolean oneEditAway(String first, String second) {
		int len1 = first.length(), len2 = second.length();
		if (len1 < len2) {// 让first的长度最长
			return oneEditAway(second, first);
		}
		if (Math.abs(len1 - len2) > 1) {
			return false;
		}
		if (len1 == len2) {
			int diff = 0;
			for (int i = 0; i < len1; i++) {
				if (first.charAt(i) != second.charAt(i)) {
					diff++;
					if (diff > 1) {
						return false;
					}
				}
			}
			return true;
		}
		int i = 0, j = len2;
		while (i < len2 && first.charAt(i) == second.charAt(i)) {
			i++;
		}
		while (j > 0 && first.charAt(j) == second.charAt(j - 1)) {
			j--;
		}
		if (i == j) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		new OneAwayLcci().oneEditAway("ab", "bc");
	}
}
