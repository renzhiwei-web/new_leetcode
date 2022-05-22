package math;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
	// leetcode 464 medium 2022/5/22
	// 首先这是一道博弈论题目，思考第一种情况，若d <= m,那么先手必赢,若 m < d <= m + 1,那么先手必输。
    
	Map<Integer, Boolean> memo = new HashMap<>();
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		// 如果所有数字选完仍无法到达d，则都无法获胜
    	if ((1 + maxChoosableInteger) *(maxChoosableInteger) / 2 < desiredTotal) {
			return false;
		}
    	return dfs(maxChoosableInteger,0,desiredTotal,0);
    }
	/**
	 * 
	 * @param maxChoosableInteger
	 * @param usedNumbers  已经被使用的数字集合，使用一个正数来表示，从低位到高位，第i位为1则表示数字i已经被表示(状态压缩)
	 * @param desiredTotal
	 * @param currentTotal 已经被使用的数字的和
	 * @return
	 */
	// 若能在未选择的数字中选出一个i，使得i + currentTotal >= d,则获胜，否则，继续通过搜索判断获胜方
	private boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
		if (!memo.containsKey(usedNumbers)) {
			boolean res = false;
			for(int i = 0;i < maxChoosableInteger;i++) {
				if (((usedNumbers >> i) & 1) == 0) {// 若当前数字(注意i从0开始，实际选择的数字时i + 1)没有被使用
					if (i + 1 + currentTotal >= desiredTotal) {
						res = true;
						break;
					}
					// usedNumbers | (1 << i) 指i + 1数被使用
					if (!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
						res = true;
						break;
					}
				}
			}
			memo.put(usedNumbers, res);
		}
		return memo.get(usedNumbers);
	}
}
