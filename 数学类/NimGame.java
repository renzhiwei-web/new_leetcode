class NimGame {
   //leetcode 292 simple 2022/4/14
   //博弈论，找到对手赢或者己方赢的情况，找到规律
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
