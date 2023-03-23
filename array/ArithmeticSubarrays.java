package array;

import java.util.*;

public class ArithmeticSubarrays {
    // leetcode 1630 medium 2023/3/23
    // 暴力法
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int k = r[i] - l[i] + 1;
            int[] newArray = new int[k];
            System.arraycopy(nums,l[i],newArray,0,k);
            Arrays.sort(newArray);
            boolean temp = check(newArray);
            ans.add(temp);
        }
        return ans;
    }

    private boolean check(int[] array) {
        int i = 0;
        int d = 0;
        while (i < array.length - 1){
            int d_k = array[i + 1] - array[i];
            if (i == 0) {
                d = d_k;
            }else {
                if (d != d_k) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    // 使用数学方法进行解题，等差数列的性质
    public List<Boolean> checkArithmeticSubarrays1(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; ++i) {
            ans.add(check1(nums, l[i], r[i]));
        }
        return ans;
    }

    private boolean check1(int[] nums, int l, int r) {
        Set<Integer> s = new HashSet<>();
        int n = r - l + 1;
        int a1 = 1 << 30, an = -a1;
        for (int i = l; i <= r; ++i) {
            s.add(nums[i]);
            a1 = Math.min(a1, nums[i]);
            an = Math.max(an, nums[i]);
        }
        if ((an - a1) % (n - 1) != 0) {
            return false;
        }
        int d = (an - a1) / (n - 1);
        for (int i = 1; i < n; ++i) {
            if (!s.contains(a1 + (i - 1) * d)) {
                return false;
            }
        }
        return true;
    }
}
