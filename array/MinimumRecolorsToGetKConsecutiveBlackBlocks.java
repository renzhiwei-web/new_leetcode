package array;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    // leetcode 2379 simple 2023/3/9
    // 由题意可得，使用滑动窗口即可解题
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int left = 0, right = 0;
        int countW = 0;
        while(right < k){
            countW += blocks.charAt(right) == 'W' ? 1 : 0;
            right++;
        }
        int ans = countW;
        while (right < n){
            countW += blocks.charAt(right) == 'W' ? 1 : 0;
            countW -= blocks.charAt(left) == 'W' ? 1 : 0;
            ans = Math.min(ans,countW);
            left++;
            right++;
        }
        return ans;
    }

}
