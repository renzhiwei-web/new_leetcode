package math;

public class MaximumScoreFromRemovingStones {
    // leetcode 1753 medium 2022/12/21
    // 由于只有三堆石子，所以使用贪心的策略，每次从最多的两堆石子中取石子
    // 可以使用模拟的过程来解题，但是时空复杂度大
    // 所以使用数学方式来直接求解，假设a<b<c，共分为两种情况
    // a+b < c，这时ans = （a+b）
    // a+b >=c，这时ans = (a+b+c)/2，向下取整
    public int maximumScore(int a, int b, int c) {
        int sum = a+b+c;
        int max = Math.max(Math.max(a,b),c);
        return Math.min(sum - max,sum / 2);
    }
}
