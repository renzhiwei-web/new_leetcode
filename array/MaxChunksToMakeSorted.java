package array;

public class MaxChunksToMakeSorted {
	// leetcode 769 medium 2022/8/13
	// ������ɵã�����������������������arr[i] = i
	// ���������ֿ����������ԭarr[i] = i,�Ϳ��Ե�����һ�飬�Դ˷�ԭ�򣬽��зֿ�
    public int maxChunksToSorted(int[] arr) {
    	int len = arr.length;
    	int ans = 0,max = 0;
    	for(int i = 0;i < len;i++) {
    		max = Math.max(max, arr[i]);
    		if (max == i) {
				ans++;
			}
    	}
    	return ans;
    }
}
