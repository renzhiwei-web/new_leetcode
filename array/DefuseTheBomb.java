package array;

public class DefuseTheBomb {
	// leetcode 1652 simple 2022/9/24
	// 简单模拟一下即可
    public int[] decrypt1(int[] code, int k) {
    	int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        for (int i = 0; i < n; ++i) {
            if (k > 0) {
                for (int j = i + 1; j < i + k + 1; ++j) {
                    ans[i] += code[j % n];
                }
            } else {
                for (int j = i + k; j < i; ++j) {
                    ans[i] += code[(j + n) % n];
                }
            }
        }
        return ans;
    }
    
    // 使用前缀和思想
    public int[] decrypt(int[] code, int k) {
    	int n = code.length;
    	int[] ans = new int[n];
    	if (k == 0) {
			return ans;
		}
    	int[] sum = new int[n << 1 | 1]; // 前缀和数组为 2 * n + 1
    	for(int i = 0;i < n << 1;i++) {
    		sum[i + 1] = sum[i] + code[i % n];
    	}
    	for(int i = 0;i < n;i++) {
    		if (k > 0) {
				ans[i] = sum[i + k + 1] - sum[i + 1];
			}else {
				ans[i] = sum[i + n] - sum[i + k + n];
			}
    	}
    	return ans;
    }
}
