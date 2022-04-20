package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThirdMaximumNumber {
	// leetcode 414 simple 2022/4/20
	// 首先容易想到进行利用排序
	public int thirdMax1(int[] nums) {
		// 由于有重复数字，首先需要去重
		Set<Integer> set = new HashSet<>();
		for(int i : nums) {
			set.add(i);
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		return list.size() < 3 ? list.get(list.size() - 1) : list.get(list.size() - 3); 
	}
	
	// 通过有序数组集合
	public int thirdMax2(int[] nums) {
		// 红黑树
		TreeSet<Integer> set = new TreeSet<>();
		for(int i : nums) {
			set.add(i);
			if (set.size() > 3) {
				set.remove(set.first());//删除集合中最小的数
			}
		}
		return set.size() == 3 ? set.first() : set.last();
	}
	
	// 利用最大值，次大值的思想进行一次遍历
	public int thirdMax(int[] nums) {
		// 由于题目中所给的nums[i]的取值范围，所以不能设定初始值为int型的最小值
		// 两种方法：1 设定初始值为long型的最小值，2设定初始值为Integer类型，并设定为null
		Integer a = null,b = null,c = null;
		for(int num : nums) {
			if(a == null || num > a) {
				c = b;
				b = a;
				a = num;
			}else if (a > num && (b == null || num > b)) {
				c = b;
				b = num;
			}else if (b != null && b > num && (c == null || num > c)) {
				c = num;
			}
		}
		return c == null ? a : c;
	}
}
