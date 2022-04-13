class Solution {
    public int addDigits(int num) {//数学方法
        return (num - 1) % 9 + 1;
    }
  
    public int addDigits1(int num) {//模拟方法
        while(num >= 10){
            int sum = 0;
            while(num > 0){
                sum += (num % 10);
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
