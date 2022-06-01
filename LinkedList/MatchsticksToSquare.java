package array;

import java.util.Arrays;

public class MatchsticksToSquare {
	// leetcode 473 medium 2022/6/1
	// 首先想到正方形的每条边是否能由火柴组成
    public boolean makesquare1(int[] matchsticks) {
    	int sum = 0;
    	for(int matchstick : matchsticks) {
    		sum += matchstick;
    	}
    	if (sum % 4 != 0) {
			return false;
		}
    	// 从大到小进行排序
    	Arrays.sort(matchsticks);
    	for(int i = 0,j = matchsticks.length - 1;i < j;i++,j--) {
    		int temp = matchsticks[i];
    		matchsticks[i] = matchsticks[j];
    		matchsticks[j] = temp;
    	}
    	
    	int[] edges = new int[4];
    	return dfs(0,matchsticks,edges,sum / 4);
    }

	private boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
		if (index == matchsticks.length) {
			return true;
		}
		for(int i = 0;i < edges.length;i++) {
			edges[i] += matchsticks[index];
			if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
				return true;
			}
			edges[i] -= matchsticks[index];
		}
		return false;
	}
}
