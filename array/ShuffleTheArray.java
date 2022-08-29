package array;

public class ShuffleTheArray {
	// leetcode 1470 simple 2022/8/29
	// ����һ��ʹ�ö���Ŀռ�
    public int[] shuffle1(int[] nums, int n) {
    	int[] ans = new int[2 * n];
    	for(int i = 0;i < n;i++) {
    		ans[2 * i] = nums[i];
    		ans[2 * i + 1] = nums[n + i];
    	}
    	return ans;
    }
    
    // ��������ԭ�ؽ������ݱ仯
    // ����int��ռ32��bit������Ŀ�и������ݷ�ΧΪ1000���ڣ������ռ10��bit
    public int[] shuffle(int[] nums, int n) {
    	for(int i = 0; i < 2 * n; i ++){
            int j = i < n ? 2 * i : 2 * (i - n) + 1;//i��ԭʼ���ݣ�j�����ݵ����±�
            nums[j] |= ((nums[i] & 1023) << 10);//��nums[i]��10λ��ȡ��ԭ���ݣ���nums[j]��11-20bitλ����
        }
        for(int i = 0;i < 2 * n;i++) nums[i] >>= 10;//����10λ����λ��0��ֻ�����������к������
        return nums;
    }
}
