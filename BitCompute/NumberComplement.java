class NumberComplement {
    public int findComplement(int num) {//位运算不熟悉
        //5 + 2 = 7（111） -> 2^3 - 1;
        //利用上述规律做题
        long a = 1;
        while(true){
            if(num >= a){
                a <<= 1;
            }else{
                return (int)a - num - 1;
            }
        }

    }
}
