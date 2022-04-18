package stringclass;

public class ReverseVowelsOfAString {
	// leetcode 345 simple，2022/4/17
	// 翻转问题要想到双指针
	public String reverseVowels(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		int i = 0;
		int j = len - 1;
		while(i < j) {
			while(i < len && !isVowels(arr[i])) {
				i++;
			}
			while(j > 0 && !isVowels(arr[j])) {
				j--;
			}
			if(i < j) {
				swap(arr,i,j);
				i++;
				j--;
			}
		}
		return new String(arr);
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
	}

	private boolean isVowels(char c) {
		return "aeiouAEIOU".indexOf(c) >= 0;
	}
}
