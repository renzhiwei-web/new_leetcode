package array;

public class SequenceReconstruction {
	// leetocde 2596 medium 2022/7/23
	// ѧϰ��������
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
    	int n = nums.length;
    	int[] arr = new int[n + 1];
    	arr[0] = -1;
    	for(int[] sequence : sequences) {
    		for(int i = 1;i < sequence.length;i++) {
    			//�����ǰ�ڵ�ĳ��Ƚڵ����ԭ����¼�ĳ��Ƚڵ����滻����֮���䡣
    			// ������֤���еĽڵ����Ϊ1
    			arr[sequence[i]] = sequence[i-1] > arr[sequence[i]] ? sequence[i-1] : arr[sequence[i]];
    			
    		}
    	}
    	int p = nums[n - 1];
    	while(p != -1) {
    		p = arr[p];
    		n--;
    	}
    	return n == -1;
    }
}
