package array;

public class TwoSumIiInputArrayIsSorted {
    // leetcode 167 medium 2022/12/4
    // 双指针
    public int[] twoSum(int[] numbers, int target) {

        int i = 0,j = numbers.length - 1;
        while(i < j){
            int tmp = numbers[i] + numbers[j];
            if (tmp == target){
                return new int[]{i + 1,j + 1};
            }
            if (tmp > target) {
                j--;
            }else {
                i++;
            }
        }
        return null;
    }
}
