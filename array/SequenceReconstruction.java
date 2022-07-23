package array;

public class SequenceReconstruction {
	// leetocde 2596 medium 2022/7/23
	// 学习拓扑排序
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
    	int n = nums.length;
    	int[] arr = new int[n + 1];
    	arr[0] = -1;
    	for(int[] sequence : sequences) {
    		for(int i = 1;i < sequence.length;i++) {
    			//如果当前节点的出度节点大于原来记录的出度节点则替换，否之不变。
    			// 这样保证所有的节点出度为1
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
