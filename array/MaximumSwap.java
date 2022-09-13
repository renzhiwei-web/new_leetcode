package array;

public class MaximumSwap {
	// leetcode 670 medium 2022/9/13
	// 我们可以从头开始遍历每一位，选出后面最大的数，如果这个最大的数比当前位置大，那就交换他们，但是，这个过程只能做一次。

    // 所以，这个过程就是选择排序的过程，只是只执行了一次而已。
    public int maximumSwap(int num) {
    	if (num % 10 == num) {
			return num;
		}
    	char[] chars = String.valueOf(num).toCharArray();
    	for (int i = 0;i < chars.length;i ++) {
			int maxIndex = i;
			for(int j = chars.length - 1;j > i;j--) {
				if (chars[maxIndex] < chars[j]) {
					maxIndex = j;
				}
			}
			
			if (maxIndex != i) {
				char temp = chars[maxIndex];
				chars[maxIndex] = chars[i];
				chars[i] = temp;
				return Integer.parseInt(new String(chars));
			}
		}
    	return num;
    }
}
