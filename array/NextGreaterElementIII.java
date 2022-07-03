package array;

public class NextGreaterElementIII {
	// leetcode 556 medium 2022/7/3
	// 将n转成成字符串，实际上求字符串的下一个排列
	// 与leetcode 31 题相似
    public int nextGreaterElement(int n) {
    	char[] nums = Integer.toString(n).toCharArray();
    	int i = nums.length - 2;
    	// 从后向前查找第一个顺序对，满足a[i] < a[i + 1]，这样较小数即为a[i]。此时[i + 1,n)必然是降序序列
    	while(i >= 0 && nums[i] >= nums[i + 1]) {
    		i--;
    	}
    	// 如果没有找到，则说明没有下个排列组合比所给的数更大
    	if (i < 0) {
			return -1;
		}
    	// 在[i + 1,n)中查找第一个a[i] < a[j]的数
    	int j = nums.length - 1;
    	while(j >= 0 && nums[i] >= nums[j]) {
    		j--;
    	}
    	
    	swap(nums,i,j);
    	reverse(nums,i + 1);
    	long ans = Long.parseLong(new String(nums));
    	return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }
    
    public void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
