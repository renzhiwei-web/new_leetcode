class UglyNumber {
    public boolean isUgly(int n) {
        //leetcode 263 ,simple,2022/4/14
        //题目中是只包含，不一定是全包含
        if (n <= 0){
            return false;
        }
        int[] factors = {2,3,5};
        for(int factor : factors){
            while(n % factor == 0){
                n /= factor;
            }
        }
        return n == 1;
    }
}
