package stringclass;

public class ReformatTheString {
	// leetcode 1417 simple 2022/8/11
	// 使用双指针思想
    public String reformat(String s) {
    	int sumDigit = 0;
    	for(int i = 0;i < s.length();i++) {
    		char c = s.charAt(i);
    		if (Character.isDigit(c)) {
				sumDigit++;
			}
    	}
    	int sumAlpha = s.length() - sumDigit;
    	if (Math.abs(sumAlpha - sumDigit) > 1) {
			return "";
		}
    	boolean flag = sumDigit > sumAlpha;
    	char[] arr = s.toCharArray();
    	for(int i = 0,j = 1;i < s.length();i += 2) {
    		if (Character.isDigit(arr[i]) != flag) {
				while(Character.isDigit(arr[j]) != flag) {
					j += 2;
				}
				swap(arr,i,j);
			}
    	}
    	return new String(arr);
    }

	private void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
}
