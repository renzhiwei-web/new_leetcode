package stringclass;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
	// leetcode 1784 simple 2022/10/3
	// ��ʵ���ж��ַ����Ƿ��������������1���ұ�������0���
    public boolean checkOnesSegment(String s) {
    	return !s.contains("01");
    }
}
