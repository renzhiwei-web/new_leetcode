package array;

public class MaximumFruitsHarvestedAfterAtMostKSteps {
    // leetcode 2106 2023/5/4
    // 不直接得出最大的采摘水果数，而是通过设定区间，判断此区间是否满足startPos与k，再求出此区间的最大采摘水果数
    // 然后利用双指针遍历所有类似的区间
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0,s = 0;
        for (int i = 0,j = 0; j < fruits.length; j++) {
            int pj = fruits[j][0],fj = fruits[j][1];
            // 每次遍历都将右区间加入，然后固定右区间，移动左指针
            s += fj;
            // 保证左指针小于等于右指针的前提下
            // 如果区间内的最小步数大于k，则移动左指针，直到符合条件
            while (i <= j && pj - fruits[i][0] + Math.min(Math.abs(startPos - fruits[i][0]),Math.abs(startPos - pj)) > k){
                s -= fruits[i++][1];
            }
            ans = Math.max(ans,s);
        }
        return ans;
    }
}
