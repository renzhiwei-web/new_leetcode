package array;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            char[] cs = ss[i].toCharArray();
            reverseString(cs);
            sb.append(cs);
            if (i != ss.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    private void reverseString(char[] s) {
        int left = 0,right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
