package array;

public class TeemoAttacking {
	//leetcode 495 simple 2022/4/26
	// 简单模拟，因为每次攻击结果与上次攻击时间有关，所以last记录上次攻击毒的持续终点时间
    public int findPoisonedDuration(int[] timeSeries, int duration) {
    	int len = timeSeries.length;
    	int ans = 0;
    	int last = -1;
    	for(int i = 0;i < len;i++) {
    		int temp = timeSeries[i] + duration - 1;//记录这次毒发的持续终点时间
    		ans += last < timeSeries[i] ? duration : temp - last;//如果上次毒发终点时间小于这次攻击时间，则毒发时间不重合，直接增加毒发持续时间即可
    		//若上次毒发终点时间大于等于这次攻击时间，则将这次毒发持续终点时间-上次毒发持续终点时间，即这次中毒的持续时间
    		last = temp;
    	}
    	return ans;
    }
}
