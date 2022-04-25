package math;

public class ConstructTheRectangle {
	// leetcode 492 simple 2022/4/25
	// 注意此类题遍历的起点是area的平方根
    public int[] constructRectangle(int area) {
    	for(int i = (int)(Math.sqrt(area)); ;i--) {
    		if (area % i == 0) {
				return new int[] {area / i,i};
			}
    	}
    	// 此题解是错误的，不能保证i >= area / i
//    	for(int i = (int)(Math.sqrt(area)); ;i++) {
//    		if (area % i == 0) {
//				return new int[] {i,area / i};
//			}
//    	}
    }
}
