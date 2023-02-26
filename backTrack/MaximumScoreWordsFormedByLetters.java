package backTrack;

public class MaximumScoreWordsFormedByLetters {
    // leetocde 1255 hard 2023/2/26
    // 由于words集合很小，所以使用遍历所有子集的方式进行解题
    // 使用位运算进行状态压缩
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[26];
        for (int i = 0; i < letters.length; i++) {
            cnt[letters[i] - 'a']++;
        }
        int n = words.length;
        int ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1){
                    for (int k = 0; k < words[j].length(); k++) {
                        cur[words[j].charAt(k) - 'a']++;
                    }
                }
            }
            boolean ok =true;
            int t = 0;
            for (int j = 0; j < 26; j++) {
                if (cur[j] > cnt[j]){
                    ok = false;
                    break;
                }
                t += cur[j] * score[j];
            }
            if (ok && ans < t){
                ans = t;
            }
        }
        return ans;
    }
}
