package array;

import java.util.HashMap;
import java.util.Map;

public class NumberOfUnequalTripletsInArray {
    // leetcode 2475 simple 2023/613
    // 首先想到暴力算法
    public int unequalTriplets(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    // 可以使用排序或哈希算法，具体的算法流程如下，排序后，相同的数字必定相邻，假设[i,j)是相同数组的左右边界
    // 将[i,j)设为三元组的中间元素，那么符合条件的三元组就有 ==> i*(j - i) *(n - j)个
    // 哈希算法同理
    public int unequalTriplets1(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int x : nums) {
            count.merge(x,1,Integer::sum);
        }
        int ans = 0,n = nums.length,t = 0;
        for (Map.Entry<Integer,Integer> entry: count.entrySet()) {
            ans += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return ans;
    }
}
