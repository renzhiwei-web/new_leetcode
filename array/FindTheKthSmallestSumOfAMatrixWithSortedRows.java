package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTheKthSmallestSumOfAMatrixWithSortedRows {
    // leetcode 1439 hard 2023/5/28
    // 首先由暴力法出发，直接按照题目所诉过程，直接模拟得出全部的结果，然后去第k个
    // 但是由于时空复杂度太高，而且题目中数组为有序，所以只需要进行前k个过程的运算即可
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length,n = mat[0].length;
        // 保存前i-1行的结果
        List<Integer> pre = new ArrayList<>(k);
        // 前i行的结果
        List<Integer> cur = new ArrayList<>(n * k);
        pre.add(0);
        // 一行行地进行遍历
        for (int[] row : mat){
            cur.clear();
            // 将前i-1行的结果与第i进行相加，然后在排序，取前k个再放入pre中
            for (int a : pre){
                for (int b : row){
                    cur.add(a + b);
                }
            }
            Collections.sort(cur);
            pre.clear();
            for (int i = 0; i < Math.min(k, cur.size()); i++) {
                pre.add(cur.get(i));
            }
        }
        return pre.get(k - 1);
    }
}
