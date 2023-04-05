package array;

public class NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int g = gcd(a,b);
        int ans = 0;
        for (int x = 1; x * x <= g; x++) {
            if (g % x == 0) {
                ans++;
                // 如果x是g的因子，那么g/x也一定是g的因子
                if (x * x < g) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b,a % b);
    }
}
