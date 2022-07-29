package math;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
	// leetcode 593 medium 2022/7/29
	// 利用数学几何方法，判断直角坐标系上的四点是否为正方形
	//方法一： 利用正方形中对角线是边长的根号2倍
    public boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
    	Set<Integer> set = new HashSet<>();
    	// 存放点与点之间的距离平方
    	set.add(distance(p1,p2));
    	set.add(distance(p1,p3));
    	set.add(distance(p1,p4));
    	set.add(distance(p2,p3));
    	set.add(distance(p2,p4));
    	set.add(distance(p3,p4));
    	// 只有两种结果，并且距离不可以是0
    	if (set.size() != 2 || set.contains(0)) {
			return false;
		}
    	// 对角线平方是不是边长平方的2倍
    	Integer[] array = set.toArray(new Integer[2]);
    	return array[0] > array[1] ? array[0] == 2 * array[1] : array[1] == 2 * array[0];
    }

    // 返回直角坐标系中两点距离的平方
	private int distance(int[] p1, int[] p2) {
		int edge1 = p1[0] - p2[0];
		int edge2 = p1[1] - p2[1];
		return edge1 * edge1 + edge2 * edge2;
	}
	// 如果是正方形，那么任意三点组成的一定是等腰直角三角形
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		return isIsoscelesRightTriangle(p1,p2,p3) && isIsoscelesRightTriangle(p1,p2,p4) && isIsoscelesRightTriangle(p1,p3,p4) && isIsoscelesRightTriangle(p2,p3,p4);
	}

	private boolean isIsoscelesRightTriangle(int[] p1, int[] p2, int[] p3) {
		int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int d2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
        int d3 = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
        return d1 > d2 && d2 == d3 && d1 == d2 + d3 ||
                d2 > d3 && d1 == d3 && d2 == d1 + d3 ||
                d3 > d1 && d2 == d1 && d3 == d2 + d1;
	}
}
