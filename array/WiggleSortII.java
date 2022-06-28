package array;

import java.util.Arrays;

public class WiggleSortII {
	//leetcode 324 medium 2022/6/28
	// ʹ����ٿռ�ķ�����ʱ�临�Ӷ�Ϊo(n)
    public void wiggleSort(int[] nums) {
    	int[] clone = nums.clone();
    	Arrays.sort(clone);
    	//����ָ��
        int left = (nums.length - 1) / 2, right = nums.length - 1;
        //���η���
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = clone[left];
                left--;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }
    }
}
