package array;

import java.util.Arrays;

public class StatisticsFromALargeSample {
    // leetcode 1093 medium 023/5/27
    // 简单模拟，只是求中位数时，需要从中位数的定义出发，去求中位数
    public double[] sampleStats(int[] count) {
        int len = count.length;
        int total = Arrays.stream(count).sum();
        double min = -1.;
        double max = -1.;
        double mean = 0.;
        double median = 0.;
        int mode = 0;
        int maxFreq = 0;
        int cnt = 0;
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            if (count[i] == 0) {
                continue;
            }
            sum += (long) count[i] * i;
            if (min == -1) {
                min = i;
            }
            max = i;
            if (cnt < right && cnt + count[i] >= right) {
                median += i;
            }
            if (cnt < left && cnt + count[i] >= left) {
                median += i;
            }
            cnt += count[i];
            if (count[i] > maxFreq) {
                mode = i;
                maxFreq = count[i];
            }
        }
        mean = (double) sum / total;
        median = median / 2.0;
        return new double[]{min, max, mean, median, mode};
    }
}
