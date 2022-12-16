package array;


public class MinimumElementsToAddToFormAGivenSum {
    // leetcode 1785 medium 2022/12/16
    // 使用贪心法进行模拟，学习向上取整
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long dvalue = Math.abs(goal - sum);
        return (int) ((dvalue + limit - 1) / limit);// 向上取整
    }
}
