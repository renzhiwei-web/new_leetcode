package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetIntersectionSizeAtLeastTwo {
	// leetcode 757 hard 2022/7/22
	// 使用贪心算法
    public int intersectionSizeTwo(int[][] intervals) {
    	int n = intervals.length;
    	int ans = 0;
    	int m = 2;
    	Arrays.sort(intervals,(a,b) -> {
    		//当 ss 相同时按照 ee 降序来进行排序，这样可以实现在处理与交集集合相交元素个数小于 mm 个的区间 [si,ei]时，保证不足的元素都是在区间的开始部分，
    		//即我们可以直接从区间开始部分进行往交集集合中添加元素。
    		if (a[0] == b[0]) {
				return b[1] - a[1];
			}
    		return a[0] - b[0];
    	});
    	List<Integer>[] temp = new List[n];
    	for(int i = 0;i < n;i++) {
    		temp[i] = new ArrayList<>();// 用来保存每个集合与区间的交集
    	}
    	//排序后从后往前进行遍历，每次选取与当前交集集合相交为空的区间的最左边的元素即可，然后往前判断前面是否有区间能因此产生交集，产生交集的直接跳过即可。
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
