package binarySearch;
public class ArrangingCoins {
	public int arrangeCoins(int n) {
        long l = 0,r = (long)n + 1;//当n=2^31-1时，会越界，所以使用long型
        while(l + 1 != r){
            long mid = (l + r) / 2;
            if(mid * (mid + 1) / 2 <= n){ // 划分区域，当此条件满足时，则mid值是蓝区域，所以left = mid，若不满足，则此区域是红区域
                l = mid;
            }else{
                r = mid;
            }
        }
        // 判断返回的区域，显然本题返回的区域应该是蓝色区域
        return (int)l;
    }
	
	public static void main(String[] args) {
		ArrangingCoins arrangingCoins = new ArrangingCoins();
		arrangingCoins.arrangeCoins(2147483647);
	}
}
