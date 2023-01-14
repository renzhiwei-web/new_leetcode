package math;

public class NumberOfDifferentSubsequencesGcds {
    // leetcode 1819 hard 2023/1/14
    // 由题意可得，若使用暴力法进行回溯，则一定会超时
    // 由于是求最大公约数，所以可以采用逆向思维，判断子序列中的数是否是 约数 的倍数
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int ans = 0,mx = 0;
        for (int num : nums) {
            mx = Math.max(num, mx);
        }
        boolean[] has = new boolean[mx + 1];
        for (int num : nums) {
            has[num] = true;
        }
        for (int i = 1; i <= mx; i++) {
            int g = 0;// 0 和任何数x的最大公约数都是x
            // 枚举 i的倍数j
            // j+=i是为了减少遍历的数目
            for (int j = i;j <= mx && g != i;j += i){
                if (has[j]){// 如果nums中存在j
                    g = gcd(g,j); // 更新最大公约数
                }

            }
            if (g == i){
                ans++;
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        while(a != 0){
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
}
