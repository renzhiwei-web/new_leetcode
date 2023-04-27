package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        // leetcode  1048 medium 2023/4/27
        // 使用动态规化进行解题
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // 使用字典作为dp数组
        Map<String,Integer> d = new HashMap<>();
        int ans = 0;
        for (String s : words) {
            int x = 0;
            for (int i = 0; i < s.length(); i++) {
                String t = s.substring(0,i) + s.substring(i + 1);
                x = Math.max(x,d.getOrDefault(t,0) + 1);
            }
            d.put(s,x);
            ans = Math.max(ans,x);
        }
        return ans;
    }
}
