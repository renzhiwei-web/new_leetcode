package designClass;

import java.util.Random;

public class RandomPointInNonOverlappingRectangles {
	// leetcode 497 medium 2022/6/9
	// 等概率随机抽样题目，多个抽样区进行随机抽样，要求每个个体概率相同
	// 需要根据所有的抽样区进行面积进行抽样，这样抽样区中的每个个体被抽取的概率相同
	int[][] rs;
	int[] sum;
	int n;
	Random random = new Random();
    public RandomPointInNonOverlappingRectangles(int[][] rects) {
    	rs = rects;
    	n = rs.length;
    	sum = new int[n + 1];
    	for(int i = 1;i <=n;i++) {
    		sum[i] = sum[i - 1] + (rs[i - 1][2] - rs[i - 1][0] + 1) * (rs[i - 1][3] - rs[i - 1][1] + 1);
    	}
    }
    
    public int[] pick() {
    	// 利用前缀和求得所有矩形的面积， +1是因为面积最低值应该为1；
    	int val = random.nextInt(sum[n]) + 1;
    	int l = 0,r = n;
    	// 二分法的目的是通过前缀和，来查找val值所在的矩形
    	while(l < r) {
    		int mid = ( l + r ) >> 1;
    		if (sum[mid] >= val) {
				r = mid;
			}else {
				l = mid + 1;
			}
    	}
    	int[] cur = rs[r - 1];
    	int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0];
    	int y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
    	return new int[] {x,y};
    }
}
