package stringclass;

public class LargestSubstringBetweenTwoEqualCharacters {
	// leetcode 2022/9/17
	// ¼òµ¥Ä£Äâ¼´¿É
    public int maxLengthBetweenEqualCharacters(String s) {
    	char[] ss = s.toCharArray();
    	int len = ss.length;
    	int[][] hash = new int[26][2];
    	int ans = -1;
    	for(int i = 0;i < len;i++) {
    		int k = ss[i] - 'a';
    		if (hash[k][0] == 0) {
				hash[k][0] = (i + 1);
			}else {
				hash[k][1] = (i + 1);
				ans = Math.max(ans, hash[k][1] - hash[k][0] - 1);
			}
    	}
    	return ans;
    }
}
