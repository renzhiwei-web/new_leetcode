package stringclass;

public class MergeStringsAlternately {
    // leetcode 1768 simple 2022/10/23
    // 简单模拟即可
    public String mergeAlternately(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < cs1.length && i < cs2.length){
            sb.append(cs1[i]);
            sb.append(cs2[i]);
            i++;
        }
        while(i < cs1.length){
            sb.append(cs1[i]);
            i++;
        }
        while(i < cs2.length){
            sb.append(cs2[i]);
            i++;
        }
        return sb.toString();
    }
}
