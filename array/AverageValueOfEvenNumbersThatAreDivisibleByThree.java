package array;

public class AverageValueOfEvenNumbersThatAreDivisibleByThree {
    // leetcode 2455 easy 2023/5/29
    // 简单模拟即可
    public int averageValue(int[] nums) {
        int sum = 0,cnt = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                cnt++;
            }
        }
        if (cnt == 0){
            return 0;
        }
        return sum / cnt;
    }
}
