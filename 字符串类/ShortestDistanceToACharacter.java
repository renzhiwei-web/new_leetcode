package stringclass;


public class ShortestDistanceToACharacter {
	// leetcode 821 simple 2022/4/19
	// 首先容易想到暴力法，通过获取c的索引，遍历获取每个字符的索引
	public int[] shortestToChar1(String s, char c) {
		char[] chss = s.toCharArray();
		int len = chss.length;
		int[] ans = new int[len];
		// 如果遍历当前字符对于每个c字符距离，则时间复杂度过高，这里进行优化，只计算当前字符距左边c，与右边c距离
		for(int i = 0;i < len;i++) {
			if(chss[i] == c) {
				continue;
			}
			int left = i - 1;
			int right = i + 1;
			while(left >= 0 && chss[left] != c) {
				left--;
			}
			while(right < len && chss[right] != c) {
				right++;
			}
			if(left >= 0 && chss[left] == c && right < len && chss[right] == c) {
				ans[i] = Math.min(i - left, right - i);
			}else if (left >= 0 && chss[left]== c) {
				ans[i] = i - left;
			}else {
				ans[i] = right - i;
			}
		}
		return ans;
	}
	
	// 对暴力法进行优化，进行两次遍历，在遍历过程中，记录c字符的索引
	public int[] shortestToChar(String s, char c) {
		int len = s.length();
		char[] chss = s.toCharArray();
		int[] ans = new int[len];
		for(int i = 0,idx = -len;i < len;i++) {//idx记录c字符的索引
			if(chss[i] == c) {
				idx = i;
			}
			ans[i] = i - idx;
		}
		for(int i = len - 1,idx = len * 2;i >= 0;i--) {
			if(chss[i] == c) {
				idx = i;
			}
			ans[i] = Math.min(ans[i], idx - i);
		}
		return ans;
		
	}
}
