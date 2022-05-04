package array;

public class EliminationGame {
	// leetcode 390 medium 2022/5/4
	// 首先容易想到进行暴力模拟求解
	// 暴力求解模拟会超时，使用等差数列进行模拟
    public int lastRemaining1(int n) {
    	int ans = 1;//其实表示的是每一轮剩下的首端数字
    	int k = 0,cnt = n,step = 1;
    	//k表示游戏进行的次数，cnt表示数组中剩余的数字，step表示公差（相邻两个数的差）
    	while(cnt != 1) {
    		if (k % 2 == 0) {//当游戏进行到偶数(k >= 0)次时，有两种情况，当cnt是奇数是，首尾两个数都消除，当cnt是偶数时，尾数不消除
				//只考虑首端数
    			ans = ans + step;
			}else {//否则反向，与正向消除类似
				if (cnt % 2 == 1) {
					ans = ans + step;//当数组数字只剩下奇数个时，首尾两端都要被消除，
				}//偶数个时，首端不被消除
			}
    		k++;
    		cnt /= 2;
    		step *= 2;
    	}
    	return ans;
    }
    
    // 使用约瑟夫环方法进行求解
    //https://leetcode-cn.com/problems/elimination-game/solution/gong-shui-san-xie-yue-se-fu-huan-yun-yon-x60m/
    public int lastRemaining(int n) {
    	return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
