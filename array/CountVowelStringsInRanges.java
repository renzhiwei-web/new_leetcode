package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelStringsInRanges {
    // leetcode2559 2023/6/2 medium
    // 使用前缀和简单模拟即可
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len = words.length;
        int[] prefix = new int[len + 1];
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','u','i','o'));
        for (int i = 0; i < len; i++) {
            String word = words[i];
            char first = word.charAt(0),last = word.charAt(word.length() - 1);
            if (set.contains(first) && set.contains(last)){
                prefix[i + 1] = prefix[i] + 1;
            }else {
                prefix[i + 1] = prefix[i];
            }
        }
        int n = queries.length;;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return ans;
    }
}
