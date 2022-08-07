package array;

import java.util.List;

public class ExclusiveTimeOfFunctions {
	// leetcode 636 medium 2022/8/7
	// 括号匹配问题，使用栈的思想
    public int[] exclusiveTime(int n, List<String> logs) {
    	int[] ans = new int[n];
    	int[][] stack = new int[logs.size() + 1][2];
    	for(int i = 0,p = 0;i < logs.size();i++) {
    		String[] log = logs.get(i).split(":");
    		int id = Integer.valueOf(log[0]);
    		int status = log[1].equals("start") ? 1 : 0;
    		int time = Integer.valueOf(log[2]);
    		if (status == 1) {// 这是一个开始，入栈
				stack[p][0] = time;// 开始时间
				stack[p][1] = 0;// 被占用时间0
				p++;
			}else {//这是一个结束，同栈顶配对
				int[] s = stack[--p];
				int me = time - s[0] + 1;// 函数结束执行时，总执行时间
				int cur = me - s[1];// 总执行时间 - 被占用的时间，就是独占cpu的时间
				ans[id] += cur;
				if (p != 0) {// 更新占用时间
					stack[p - 1][1] += me;
				}
			}
    	}
    	return ans;
    }
}
