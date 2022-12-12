package stringclass;

public class SumOfBeautyOfAllSubstrings {
    // leetcode 1781 medium 2022/12/12
    // 目标是查找字符串的魅力值之和,由于都是小写字母，使用数组充当哈希表
    public int beautySum(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;

        for (int i = 0; i < cs.length; i++) {
            int[] map = new int[26];
            int maxFreq = 0;
            for (int j = i; j < cs.length; j++) {
                map[cs[j] - 'a']++;
                maxFreq = Math.max(maxFreq,map[cs[j] - 'a']);
                int minFreq = cs.length;
                for (int k = 0; k < 26; k++) {
                    if (map[k] > 0){
                        minFreq = Math.min(minFreq,map[k]);
                    }
                }
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }
}
