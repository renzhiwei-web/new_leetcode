package math;


public class SmallestIntegerDivisibleByK {
    // leetcode 1015 medium 2023/5/10
    // 基本的思想为，我们从 n=1 开始枚举，此时对 k 取余得余数 resid=1 mod k。
    // 如果resid 不为 0，则表示 n 当前还不能被 k 整除，我们需要增加 n 的长度。
    // 由取模公式可得，新的余数可以由就的余数取得，于是只需要记录所有余数，知道余数为0，或者余数重复
    // 优化----------------------
    // 可以证明得，当k=2,k=5的倍数时，能够被k整除的数字末尾一定不为1
    // 当k不为2或者5的倍数时，一定有解
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int reminder = 1 % k,len = 1;
        while (reminder != 0){
            reminder = (reminder * 10 + 1) % k;
            len++;
        }
        return len;
    }
}
