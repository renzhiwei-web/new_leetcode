package stringclass;

public class FinalValueOfVariableAfterPerformingOperations {
    // leetcode 2011 simple 2022/12/23
    // 简单模拟即可
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String str :
                operations) {
            if (str.indexOf('+') >= 0) {
                ans++;
            }else {
                ans--;
            }
        }
        return ans;
    }
}
