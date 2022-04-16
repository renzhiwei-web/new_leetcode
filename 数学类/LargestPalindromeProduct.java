package math;

public class LargestPalindromeProduct {
	public int largestPalindrome(int n) {
        //leetcode 479 hard,2022/4/16
        //难点是构造回文数
        if (n == 1){
            return 9;
        }
        int upper = (int)Math.pow(10,n) - 1;
        int ans = 0;
        // 两个n位整数的乘机至多是2n位整数
        for(int left = upper;ans == 0;left--){ //穷举回文数的左半部分
            long p = left;
            for(int x = left;x > 0;x /= 10){// 翻转左半部分到其自身末尾，构造回文数p,n位数就循环n次
                p = p * 10 + x % 10; 
            }
            for (long x = upper;x * x >= p;x--){
                if(p % x == 0){//判断是否是回文数的因子
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }
}
