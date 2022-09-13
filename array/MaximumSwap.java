package array;

public class MaximumSwap {
	// leetcode 670 medium 2022/9/13
	// ���ǿ��Դ�ͷ��ʼ����ÿһλ��ѡ���������������������������ȵ�ǰλ�ô��Ǿͽ������ǣ����ǣ��������ֻ����һ�Ρ�

    // ���ԣ�������̾���ѡ������Ĺ��̣�ֻ��ִֻ����һ�ζ��ѡ�
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
