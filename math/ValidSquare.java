package math;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {
	// leetcode 593 medium 2022/7/29
	// ������ѧ���η������ж�ֱ������ϵ�ϵ��ĵ��Ƿ�Ϊ������
	//����һ�� �����������жԽ����Ǳ߳��ĸ���2��
    public boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
    	Set<Integer> set = new HashSet<>();
    	// ��ŵ����֮��ľ���ƽ��
    	set.add(distance(p1,p2));
    	set.add(distance(p1,p3));
    	set.add(distance(p1,p4));
    	set.add(distance(p2,p3));
    	set.add(distance(p2,p4));
    	set.add(distance(p3,p4));
    	// ֻ�����ֽ�������Ҿ��벻������0
    	if (set.size() != 2 || set.contains(0)) {
			return false;
		}
    	// �Խ���ƽ���ǲ��Ǳ߳�ƽ����2��
    	Integer[] array = set.toArray(new Integer[2]);
    	return array[0] > array[1] ? array[0] == 2 * array[1] : array[1] == 2 * array[0];
    }

    // ����ֱ������ϵ����������ƽ��
	private int distance(int[] p1, int[] p2) {
		int edge1 = p1[0] - p2[0];
		int edge2 = p1[1] - p2[1];
		return edge1 * edge1 + edge2 * edge2;
	}
	// ����������Σ���ô����������ɵ�һ���ǵ���ֱ��������
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
