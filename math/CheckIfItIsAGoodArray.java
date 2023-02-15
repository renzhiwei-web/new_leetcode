package math;

public class CheckIfItIsAGoodArray {
    // leetcode 1250 hard 2023/2/15
    // 由题意可得，可以得知，当数组中存在互质的子集时，此数组为好数组
    // 由于子集互质，那么此数组也必定互质，所以直接判断数组的最大公约数是否为1即可
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1){
                break;
            }
        }
        return divisor == 1;

    }

    private int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
