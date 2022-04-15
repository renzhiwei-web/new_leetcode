class PowerOfThree {
    //leetcode 326 simple,2022/4/15
    //通过使用累乘法，减少时间复杂度，是对暴力法的小优化
    public boolean isPowerOfThree1(int n) {
        if (n < 0){
            return false;
        }
        int val = 3;
        while(n >= 3){
            if(n % val == 0){
                n /= val;
                val *= val;
            }else{
                if(n % 3 == 0){
                    val = 3;
                    n /= val;
                }else{
                    return false;
                }
            }
        }
        if(n == 1){
            return true;
        }
        return false;
    }
    
    //暴力法
    public boolean isPowerOfThree2(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }

    //数学做法，如果 n 为 3 的幂的话，那么必然满足 n * 3^k = 1162261467，即 n 与 1162261467 存在倍数关系。因此，我们只需要判断 n 是否为 1162261467 的约数即可。
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    
}
