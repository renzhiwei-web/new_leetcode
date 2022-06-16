package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
	// leetcode 532 medium 2022/6/16
	// ���������뵽ʹ������+˫ָ��ķ������н�𡣵����ѵ���Ҫ��ȥ��
	public int findPairs2(int[] nums, int k) {
    	int n = nums.length,ans = 0;
    	Arrays.sort(nums);
    	for(int i = 0,j = 0;i < n - 1 && j < n;i++) {
    		// �ظ��Ĳ����㣬�����ͬ��nums[i - 1]�Ѿ��������
    		if(i > 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		while(j <= i) {
    			j++;
    		}
    		while(j < n && (nums[j] < nums[i] + k)) {
    			j++;
    		}
    		//�ҵ�Ŀ��ֵ
    		if (j < n && nums[j] == nums[i] + k) {
				ans++;
			}
    	}
    	return ans;
    }
	
	// ȥ��Ҫ�뵽�������ݽṹ��set��map������ʹ��map�����
    public int findPairs1(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i : nums) {
    		map.put(i, map.getOrDefault(i, 0) + 1);
    	}
    	int ans = 0;
    	for(int i : nums) {
    		if (map.get(i) == 0) {
				continue;
			}
    		if (k == 0) {
				if (map.get(i) > 1) {
					ans++;
				}
			}else {
				int a = i - k;
				int b = i + k;
				if (map.getOrDefault(a, 0) > 0 ) {
					ans++;
				}
				if (map.getOrDefault(b, 0) > 0 ) {
					ans++;
				}
			}
    		map.put(i, 0);
    	}
    	return ans;
    }
    
    // ������Ѱ�����ԣ�����ͨ����λһ�����֣�������һ�����֣�����ʹ�ö��ֲ���������ʱ�临�Ӷ�
    public int findPairs(int[] nums, int k) {
    	int n = nums.length,ans = 0;
    	Arrays.sort(nums);
    	for(int i = 0;i < n - 1;i++) {
    		if(i > 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		int target = nums[i] + k;
    		int left = i,right = n;
    		while(left + 1 != right) {
    			int mid = (left + right) / 2;
    			if (nums[mid] == target) {
					ans++;
					break;
				}else if (nums[mid] > target) {
					right = mid;
				}else {
					left = mid;
				}
    		}
    	}
    	return ans;
    }

}
