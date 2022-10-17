package array;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
	// leetcode 904 medium 2022/10/17
	// 使用滑动窗口来进行解题
    public int totalFruit1(int[] fruits) {
    	// 哈希表存放当前滑动窗口中所有的已摘的水果种类，及其相应的个数
    	Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < fruits.length; ++i) {
            int x = fruits[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            while (cnt.size() > 2) {
                int y = fruits[j++];
                cnt.put(y, cnt.get(y) - 1);
                if (cnt.get(y) == 0) {
                    cnt.remove(y);
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
    
    // 滑动窗口优化，因为题目要求求水果最大的数目，也就是求最大的窗口
    // 所以没有必要减少窗口大小，所以当窗口中水果种类不符合题目要求时，只需要维持当前窗口大小即可，没有必要减少窗口大小
    public int totalFruit(int[] fruits) {
    	Map<Integer, Integer> cnt = new HashMap<>();
    	int j = 0;
    	int n = fruits.length;
    	for (int x : fruits) {
    		cnt.put(x, cnt.getOrDefault(x, 0) + 1);
    		// 如果新添加的水果不符合要求，只需维持窗口大小即可，不需要减小窗口
    		if (cnt.size() > 2) {
				int y = fruits[j++];
    			cnt.put(y, cnt.get(y) - 1);
    			if (cnt.get(y) == 0) {
					cnt.remove(y);
				}
			}
    	}
    	return n - j;
    }
}
