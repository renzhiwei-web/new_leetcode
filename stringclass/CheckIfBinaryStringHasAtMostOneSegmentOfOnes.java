package stringclass;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
	// leetcode 1784 simple 2022/10/3
	// 其实是判断字符串是否是由左边连续的1和右边连续的0组成
    public boolean checkOnesSegment(String s) {
    	return !s.contains("01");
    }
}
