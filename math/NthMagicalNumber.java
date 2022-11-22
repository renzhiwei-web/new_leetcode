package math;

public class NthMagicalNumber {
    // leetcode 878 hard 2022/11/22
    // 可以通过使用暴力法，但a，b可能很大，所以时间复杂度会很高
    // 从问题本质出发，求a或b的倍数的第n个数，尝试得出所有的a和b的倍数，再减去a和b的公倍数
    // 再通过二分法查找目标数
    private static int MOD =(int) 1e9 + 7;
    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a,b);
        long r = (long) n * a * b;
        long c = lcm(a,b);
        while (l <= r){
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return (int)((r + 1) % MOD);
    }

    // 求a，b的最小公倍数
    private long lcm(int a, int b) {
        return a * b / gcd(a,b);
    }

    private long gcd(int a, int b) {
        return b != 0 ? gcd(b,a % b) :a;
    }
}
