package math;

public class BulbSwitcherII {
	// leetcode 672 medium 2022/9/15
	// ͨ���ҹ�����ʵ��
	public int flipLights(int n, int presses) {
		// ��������
		if (presses == 0) {
			return 1;
		}
		// �����������
		if (n == 1) {
			return 2;
		}else if (n == 2) {
			return presses == 1 ? 3 : 4;
		}else {
			// n >= 3
			return presses == 1 ? 4 : presses == 2 ? 7 : 8;
		}
		
	}
}
