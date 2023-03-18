package stringclass;

public class SplitTwoStringsToMakePalindrome {
    // leetcode 1616 medium 2023/3/18
    // 判断是否存在回文串，使用双指针进行解题、
    // 这里采用另一个想法，采用中心扩展，进行解题
    public boolean checkPalindromeFormation(String a, String b) {
        int left = a.length() / 2 - 1;
        left = Math.min(checkPalindrome(a,a,left),checkPalindrome(b,b,left));
        left = Math.min(checkPalindrome(a,b,left),checkPalindrome(b,a,left));
        return left == -1;
    }

    private int checkPalindrome(String str1,String str2,int left) {
        int right = str1.length() - 1 - left;
        while (left >= 0 && right < str1.length()){
            if (str1.charAt(left) != str2.charAt(right)){
                break;
            }
            left--;
            right++;
        }
        return left;
    }
}
