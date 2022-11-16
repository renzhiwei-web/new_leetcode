package array;

public class GlobalAndLocalInversions {
    // leetcode 775 medium 2022/11/16
    // 最初想法，直接遍历出所有的全局逆序与局部逆序
    public boolean isIdealPermutation(int[] nums) {
        int global = 0,local = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    global++;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                local++;
            }
        }
        return global == local;
    }
    // 判断每个全局变量是不是局部变量即可
    public boolean isIdealPermutation1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j =  i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j] && j != i + 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIdealPermutation2(int[] nums) {
        int max = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < max) {
                return false;
            }
            max = Math.max(max,nums[i - 1]);
        }
        return true;
    }
}
