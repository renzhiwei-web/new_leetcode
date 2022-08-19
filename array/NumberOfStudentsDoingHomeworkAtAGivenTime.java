package array;

public class NumberOfStudentsDoingHomeworkAtAGivenTime {
	// leetcode 1450 simple 2022/8/19
	// ¼òµ¥Ä£Äâ
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    	int len = startTime.length;
    	int ans = 0;
    	for(int i = 0;i < len;i++) {
    		if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
				ans++;
			}
    	}
    	return ans;
    }
}
