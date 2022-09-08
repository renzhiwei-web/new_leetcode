package math;

public class BeautifulArrangementII {
	// leetcode 667 medium 2022/9/8
	// �Խת��
    public int[] constructArray(int n, int k) {
    	int[] ans = new int[n];
    	int i = 0;
    	// p��С����q�Ӵ�С
    	int p = 1,q = n;
    	// ����ǰk������k- 1����ͬ������
    	// ����λ�Ӵ�С��ż��λ��С����
    	for(int j = 0;j < k;j++) {
    		if (j % 2 == 0) {
				ans[i++] = p++;
			}else {
				ans[i++] = q--;
			}
    	}
    	// ����ʣ�µľ���ֵΪ1������
    	if (k % 2 == 0) {
			// ż��ʱ������
    		while(i < n) {
    			ans[i++] = q--;
    		}
		}else {
			// ����ʱ������
			while(i < n) {
				ans[i++] = p++;
			}
		}
    	return ans;
    }
}
