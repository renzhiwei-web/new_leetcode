package math;

public class BulbSwitcherII {
	// leetcode 672 medium 2022/9/15
	// 通过找规律来实现
	public int flipLights(int n, int presses) {
		// 不按开关
		if (presses == 0) {
			return 1;
		}
		// 特殊情况处理
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
