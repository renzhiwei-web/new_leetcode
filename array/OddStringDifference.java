package array;

import java.util.Arrays;

public class OddStringDifference {
    // leetcode 2451 2023/5/25 medium
    // 简单模拟即可，比较数组是否相同，使用Arrays.equals()方法
    public String oddString(String[] words) {
        int[] diff0 = get(words[0]);
        int[] diff1 = get(words[1]);
        if (Arrays.equals(diff0,diff1)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff0,get(words[i]))){
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff0,get(words[2])) ? words[1] : words[0];

    }

    public int[] get(String word){
        int[] diff = new int[word.length() - 1];
        for (int i = 0; i + 1 < word.length(); i++) {
            diff[i] = word.charAt(i + 1) - word.charAt(i);
        }
        return diff;
    }
}
