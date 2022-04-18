package tree;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
	// leetcode 386 medium,2022/4/18
	// 首先想到暴力求解，比较复杂
	// 采用字典树的思想，利用数学运算，先得出数字，在判断是否在当前范围内
	public List<Integer> lexicalOrder1(int n) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			dfs(i, n, ans);
		}
		return ans;
	}

	private void dfs(int cur, int n, List<Integer> ans) {
		if(cur > n) {
			return;
		}
		ans.add(cur);
		for(int i = 0;i < 10;i++) {
			dfs(cur * 10 + i, n, ans);
		}
	}
	
	//迭代算法
	public List<Integer> lexicalOrder(int n) {
		List<Integer> ans = new ArrayList<>();
		int cur = 1;
		for(int i = 1;i <= n;i++) {
			ans.add(cur);
			if(cur * 10 <= n) {//判断当前数*10是否在范围中
				cur *= 10;
			}else {//若不在范围中，则判断当前数末位数是否为9，或是否是范围右界。
				while(cur % 10 == 9 || cur == n) {//若是，则将当前数回退一个数量级
					cur /= 10;
				}
				cur++;
			}
		}
		return ans;
	}
}
