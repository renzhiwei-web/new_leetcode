package math;

public class CheckIfNumberIsASumOfPowersOfThree {
    // leetcode 1780 medium 2022/12/9
    // 判断当前数是否满足3机制
    public boolean checkPowersOfThree(int n) {
        while (n != 0){
            if (n % 3 == 0 || n % 3 == 1){
                n = n / 3;
            }else {
                return false;
            }
        }
        return false;
    }
}
