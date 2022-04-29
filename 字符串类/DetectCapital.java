package stringclass;

public class DetectCapital {
	// leetcode 520 simple 2022/4/29
	// 简单的字符串模拟
    public boolean detectCapitalUse(String word) {
    	if (word.toUpperCase().equals(word)) {
			return true;
		}
    	if (word.toLowerCase().equals(word)) {
			return false;
		}
    	boolean ans = true;
    	char[] letters = word.toCharArray();
    	for(int i = 0;i < letters.length;i++) {
    		if (Character.isUpperCase(letters[i]) && i != 0) {
				ans = false;
				break;
			}
    	}
    	return ans;
    }
}
