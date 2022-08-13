package array;

public class MaxChunksToMakeSorted {
	// leetcode 769 medium 2022/8/13
	// 由题意可得，由于是升序，所以排序后必有arr[i] = i
	// 由于是最大分块数，则如果原arr[i] = i,就可以单独分一块，以此分原则，进行分块
    public int maxChunksToSorted(int[] arr) {
    	int len = arr.length;
    	int ans = 0,max = 0;
    	for(int i = 0;i < len;i++) {
    		max = Math.max(max, arr[i]);
    		if (max == i) {
				ans++;
			}
    	}
    	return ans;
    }
}
