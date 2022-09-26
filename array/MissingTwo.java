package array;

public class MissingTwo {
	// ���������뵽ʹ������������ȱʧֵ�ĺͣ���Ҫ��һ����ʽ�������������δ֪��
	// �����ó˻���ʽ�����ǻ������
	// ���Խ�n������һ��Ϊ2������ȱʧֵ�͵��м�ֵΪ�ֽ磬���ǰһ��ȱʧֵ
    public int[] missingTwo1(int[] nums) {
    	int len = nums.length;
    	int n = len + 2;
    	int[] ans = new int[2];
    	int sum = 0;
    	for(int i : nums) {
    		sum += i;
    	}
    	// �������ȱʧֵ֮��
    	int ts = (1 + n) * n / 2 - sum;
    	// ����Ԫ�صķֽ�ֵ
    	int m = ts / 2; 
    	
    	// ������ת��Ϊ��ǰһ��Ԫ�ص�ֵ
    	sum = 0;
    	for(int i : nums) {
    		if (i <= m) {
				sum += i;
			}
    	}
    	int res = (1 + m) * m / 2 - sum;
    	ans[0] = res;
    	ans[1] = ts - res;
    	return ans;
    }
    
    public int[] missingTwo(int[] nums) {
    	int n = nums.length + 2;
    	int res = 0;
    	// ��������ֵ�����������
    	for (int i = 1;i <= n;i++) {
    		res ^= i;
    	}
    	for (int i : nums) {
    		res ^= i;
    	}
    	// resΪ����ȱʧֵ�������
    	int diff = res & -res; // ���res��lowbitֵ
    	// lowbitֵ��ָһ�����Ķ�������ʽ�У����λ�����һ��1�ͺ�������0��ɵ�����ʮ������ʽ��
    	// lowbit�󷨽��ͣ����������ֵ�Բ�����д�š�
    	// diff����������ֵ��lowbit��������������ȱʧ����diffλ�ϱ���һ����0��һ����1
    	int o = 0;
    	for(int i = 1;i <= n;i++) {
    		if ((diff & i) != 0) {
				o ^= i;
			}
    	}
    	for(int i : nums) {
    		if ((diff & i) != 0) {
				o ^= i;
			}
    	}
    	return new int[] {o,o ^ res};
    }
}
