package array;

public class CountIntegersWithEvenDigitSum {
    // leetcode 2180 simple 2023/1/6
    // 首先使用枚举方法进行解题
    public int countEven1(int num) {
        int ans = 0;
        for (int i = 2; i <= num; i++) {
            if (func(i)){
                ans++;
            }
        }
        return ans;
    }

    private boolean func(int i) {
        int n = i;
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum % 2 == 0;
    }

    public int countEven(int num) {
        int ans = num / 10 * 5 - 1;
        int s = 0;
        for (int x = num / 10; x > 0; x /= 10){
            s += x % 10;
        }
        ans += (num % 10 + 2 - (s & 1)) >> 1;
        return ans;
    }
}
