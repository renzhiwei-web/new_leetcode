package array;

public class NextGreaterElementIII {
	// leetcode 556 medium 2022/7/3
	// ��nת�ɳ��ַ�����ʵ�������ַ�������һ������
	// ��leetcode 31 ������
    public int nextGreaterElement(int n) {
    	char[] nums = Integer.toString(n).toCharArray();
    	int i = nums.length - 2;
    	// �Ӻ���ǰ���ҵ�һ��˳��ԣ�����a[i] < a[i + 1]��������С����Ϊa[i]����ʱ[i + 1,n)��Ȼ�ǽ�������
    	while(i >= 0 && nums[i] >= nums[i + 1]) {
    		i--;
    	}
    	// ���û���ҵ�����˵��û���¸�������ϱ�������������
    	if (i < 0) {
			return -1;
		}
    	// ��[i + 1,n)�в��ҵ�һ��a[i] < a[j]����
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
