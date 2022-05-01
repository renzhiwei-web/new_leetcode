package stringclass;

public class ReverseStringII {
	// leetcode 541 simple 2022/5/1
	// 对字符串进行分段逆转
    public String reverseStr(String s, int k) {
    	char[] letters = s.toCharArray();
    	for(int i = 0;i < letters.length;i = i + 2 * k) {
    		int r = i + k - 1;
    		reverse(letters,i,Math.min(r, letters.length - 1));
    	}
    	return String.valueOf(letters);
    }

	private void reverse(char[] letters, int i, int r) {
		while(i < r) {
			char c = letters[i];
			letters[i] = letters[r];
			letters[r] = c;
			i++;
			r--;
		}
	}
}
