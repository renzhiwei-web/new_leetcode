package math;

public class MinimumCutsToDivideACircle {
    public int numberOfCuts(int n) {
        if (n == 1){
            return 0;
        }
        if ((n & 1) == 0){
            return n >> 1;
        }
        return n;
    }
}
