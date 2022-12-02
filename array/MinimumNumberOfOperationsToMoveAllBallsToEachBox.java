package array;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    // leetcode 1769 medium 2022/12/2
    // 首先想到暴力法求解
    public int[] minOperations(String boxes) {
        char[] boxcs = boxes.toCharArray();
        int[] ans = new int[boxcs.length];
        for (int i = 0; i < ans.length; i++) {
            int count = 0;
            for (int j = 0; j < boxcs.length; j++) {
                if (j == i){
                    continue;
                }
                count += Math.abs(j - i) * (boxcs[j] - '0');
            }
            ans[i] = count;
        }
        return ans;
    }

    // 利用前缀和思想
    public int[] minOperations1(String boxes) {
        int[] result = new int[boxes.length()];
        char[] bc = boxes.toCharArray();
        int rc = 0, lc = (bc[0] == '1' ? 1 : 0); // rc:右侧'1'的总数  lc:左侧'1'的总数
        for (int i = 1; i < bc.length; i++)
            if (bc[i] == '1') {
                result[0] += i; // 初始化第1个盒子操作数
                rc++; // 右侧'1'的总数加1
            }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i-1] + lc - rc; // 第N个盒子操作数
            if (bc[i] == '1') {
                lc++; rc--; // 重新计算lc与rc的值
            }
        }
        return result;
    }
}
