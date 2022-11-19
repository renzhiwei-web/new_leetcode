package array;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        // leetcode 1732 simple 2022/11/19
        // 简单模拟，前缀和
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;
        int max = 0;
        for (int i = 1; i <= gain.length; i++) {
            altitude[i] = altitude[i - 1] + gain[i - 1];
            max = Math.max(max,altitude[i]);
        }
        return max;
    }
}
