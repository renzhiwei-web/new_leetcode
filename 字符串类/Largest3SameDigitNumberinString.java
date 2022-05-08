package stringclass;

public class Largest3SameDigitNumberinString {
	// leetcode 6056 simple 2022/5/8
	// 简单模拟即可
	public String largestGoodInteger(String num) {
		int n = num.length();
		char[] nums = num.toCharArray();
		int ansNum = Integer.MIN_VALUE;
		String ans = "";
		for (int i = 0; i + 3 <= n; i++) {
			int j = i + 1;
			while (j < i + 3) {
				if (nums[i] == nums[j]) {
					j++;
				}else {
					break;
				}
			}
			if (j == i + 3) {
				int tempNum = Integer.parseInt(num.substring(i, j));
				if (ansNum < tempNum) {
					ansNum = tempNum;
					ans = num.substring(i, j);
				}
			}
		}
		return ans;
	}
}
