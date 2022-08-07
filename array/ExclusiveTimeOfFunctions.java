package array;

import java.util.List;

public class ExclusiveTimeOfFunctions {
	// leetcode 636 medium 2022/8/7
	// ����ƥ�����⣬ʹ��ջ��˼��
    public int[] exclusiveTime(int n, List<String> logs) {
    	int[] ans = new int[n];
    	int[][] stack = new int[logs.size() + 1][2];
    	for(int i = 0,p = 0;i < logs.size();i++) {
    		String[] log = logs.get(i).split(":");
    		int id = Integer.valueOf(log[0]);
    		int status = log[1].equals("start") ? 1 : 0;
    		int time = Integer.valueOf(log[2]);
    		if (status == 1) {// ����һ����ʼ����ջ
				stack[p][0] = time;// ��ʼʱ��
				stack[p][1] = 0;// ��ռ��ʱ��0
				p++;
			}else {//����һ��������ͬջ�����
				int[] s = stack[--p];
				int me = time - s[0] + 1;// ��������ִ��ʱ����ִ��ʱ��
				int cur = me - s[1];// ��ִ��ʱ�� - ��ռ�õ�ʱ�䣬���Ƕ�ռcpu��ʱ��
				ans[id] += cur;
				if (p != 0) {// ����ռ��ʱ��
					stack[p - 1][1] += me;
				}
			}
    	}
    	return ans;
    }
}
