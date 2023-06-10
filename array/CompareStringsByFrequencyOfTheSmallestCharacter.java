package array;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    // leetcode 1170 medium 2023/6/10
    // 简单模拟
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int len = queries.length;
        int[] ans = new int[len];
        int[] cntQ = check(queries);
        int[] cntW = check(words);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words.length; j++) {
                if (cntQ[i] < cntW[j]){
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    private int[] check(String[] words) {
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = f(words[i]);
        }
        return ans;
    }

//    private int f(String word) {
//        char[] chs = word.toCharArray();
//        int[] cnt = new int[26];
//        char min = 'z';
//        for (char ch : chs) {
//            cnt[ch - 'a']++;
//            if (ch < min) {
//                min = ch;
//            }
//        }
//        return cnt[min - 'a'];
//    }

    // 利用后缀和数组减少算法的时间复杂度
    public int[] numSmallerByFrequency1(String[] queries, String[] words) {
        int[] count = new int[12];
        for (String s : words) {
            count[f(s)]++;
        }
        for (int i = 9; i >= 1; i--) {
            count[i] += count[i + 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s = queries[i];
            res[i] = count[f(s) + 1];
        }
        return res;
    }

    public int f(String s) {
        int cnt = 0;
        char ch = 'z';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < ch) {
                ch = c;
                cnt = 1;
            } else if (c == ch) {
                cnt++;
            }
        }
        return cnt;
    }
}
