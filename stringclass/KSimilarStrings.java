package stringclass;

public class KSimilarStrings {
	// leetcode 854 hard 2022/9/21
	// 使用回溯法进行遍历，注意回溯法的结束条件
	int result = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
    	return execute(s1.toCharArray(),s2.toCharArray(),0,0);
    }
	private int execute(char[] sc1, char[] sc2, int start, int current) {
		if (current >= result) {
			return result; // 如果交换次数已经超过“目前最小交换次数”，终止递归
		}
		if (start == sc1.length - 1) { // 如果已经遍历完毕
			return result = Math.min(current, result);
		}
		
		for(int i = start;i < sc1.length;i++) {
			if (sc1[i] != sc2[i]) {//当前遍历字符不匹配，则向后寻找匹配的字符
				for(int j = i + 1;j < sc2.length;j++) {
					if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
						swap(sc2,i,j);//交换
						execute(sc1, sc2, i + 1, current + 1);
						swap(sc2,i,j);// 回溯
						if (sc2[i] == sc1[j]) {// 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
							break;
						}
					}
					
				}
				return result;
			}
			
		}
		return result = Math.min(current, result);
	}
	private void swap(char[] sc, int i, int j) {
		char temp = sc[i];
		sc[i] = sc[j];
		sc[j] = temp;
		
	}
}
