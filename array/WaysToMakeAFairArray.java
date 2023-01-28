package array;

public class WaysToMakeAFairArray {
    // leetcode 1664 medium 2023/1/28
    // 由题意可得，本题难点在于删除元素后，元素索引的奇偶性也会发生变化
    public int waysToMakeFair(int[] nums) {
        int sumEven = 0,sumOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1){
                sumEven += nums[i];
            }else {
                sumOdd += nums[i];
            }
        }

        int countOdd = 0, countEven = 0,count = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0){
                int o = countOdd + (sumEven - countEven);
                int j = countEven + (sumOdd - o - nums[i]);
                if (o == j){
                    count++;
                }
                countOdd += nums[i];
            }else {
                int o = countOdd + (sumEven - countEven - nums[i]);
                int j = countEven + (sumOdd - countOdd);
                if (o == j){
                    count++;
                }
                countEven += nums[i];
            }
        }
        return count;
    }
}
