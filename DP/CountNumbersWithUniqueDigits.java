class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) { //数学方法
        // n - 1 其实代表了最大整数的位数
        if ( n == 0 ){//特判
            return 1;
        }
        if ( n == 1){
            return 10;
        }
        int ans = 10;
        int cur = 9;//当前位可取的整数的情况
        for(int i = 0;i < n - 1;i++){//i - 1 表示当前的整数的位数 - 1
            cur *= 9 - i;//以n == 2为例，第一位取1 - 9(9),第二位则取到0 - 9且除第一位的整数(9)
            ans += cur;
        }
        return ans;
    }
  
  public int countNumbersWithUniqueDigits1(int n) { //动态规划
        if( n == 0) {
            return 1;
        }
        int[] dp= new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        for(int i = 2;i <= n;i++){
            dp[i] = dp[i - 1] + (dp[i - 1] - dp[i - 2]) * (10 - i + 1);
        }
        return dp[n];
    }
}
