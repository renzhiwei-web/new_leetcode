package array;

public class SmallestEvenMultiple {
    // leetcode 2413 simple 2023/4/21
    // 简单模拟即可
    public int smallestEvenMultiple(int n) {
        return (n & 1) == 0 ? n : n << 1;
    }
}
