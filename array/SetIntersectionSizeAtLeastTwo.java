package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetIntersectionSizeAtLeastTwo {
	// leetcode 757 hard 2022/7/22
	// ʹ��̰���㷨
    public int intersectionSizeTwo(int[][] intervals) {
    	int n = intervals.length;
    	int ans = 0;
    	int m = 2;
    	Arrays.sort(intervals,(a,b) -> {
    		//�� ss ��ͬʱ���� ee ����������������������ʵ���ڴ����뽻�������ཻԪ�ظ���С�� mm �������� [si,ei]ʱ����֤�����Ԫ�ض���������Ŀ�ʼ���֣�
    		//�����ǿ���ֱ�Ӵ����俪ʼ���ֽ������������������Ԫ�ء�
    		if (a[0] == b[0]) {
				return b[1] - a[1];
			}
    		return a[0] - b[0];
    	});
    	List<Integer>[] temp = new List[n];
    	for(int i = 0;i < n;i++) {
    		temp[i] = new ArrayList<>();// ��������ÿ������������Ľ���
    	}
    	//�����Ӻ���ǰ���б�����ÿ��ѡȡ�뵱ǰ���������ཻΪ�յ����������ߵ�Ԫ�ؼ��ɣ�Ȼ����ǰ�ж�ǰ���Ƿ�����������˲�������������������ֱ���������ɡ�
    	for(int i = n - 1;i >= 0;i--) {
    		for(int j = intervals[i][0],k = temp[i].size();k < m;j++,k++) {
    			ans++;
    			help(intervals,temp,i - 1,j);
    		}
    	}
    	return ans;
    }

	private void help(int[][] intervals, List<Integer>[] temp, int pos, int num) {
		for(int i = pos;i >= 0;i--) {
			if (intervals[i][1] < num) {
				break;
			}
			temp[i].add(num);
		}
	}
	
	
}
