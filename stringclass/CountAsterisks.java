package stringclass;


public class CountAsterisks {
    // leetcode 2315 simple 2023/1/29
    // 简单模拟
    public int countAsterisks(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; ) {
            if (cs[i] == '|'){
                i++;
                while(i < cs.length && cs[i] != '|'){
                    i++;
                }
            } else if (cs[i] == '*') {
                ans++;
            }
            i++;
        }
        return ans;
    }
}
