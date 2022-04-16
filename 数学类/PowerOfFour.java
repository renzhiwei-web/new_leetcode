class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        // leetcode 342,simple,2022/4/16
        // 先转成2的幂的问题，lowbit 可以快速求得 x 二进制表示中最低位 1 表示的值。如果一个数 n 是 2 的幂，那么有 lowbit(n) = n 的性质（2 的幂的二进制表示中必然是最高位为 1，低位为 0）。
        if (n <= 0) return false;
        int x = (int)Math.sqrt(n);
        return x * x == n && (x & -x) == x;
    }
}
