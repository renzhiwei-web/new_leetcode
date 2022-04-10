class KthMissingPositiveNumber {
    //暴力法
    // public int findKthPositive(int[] arr, int k) {
    //     int i = 0; //数组的下标
    //     int ans = 0;
    //     int n = 1; //完整的正整数序列
    //     int count = 0;// 缺失数组的个数
    //     while(count < k){
    //         if(i < arr.length && arr[i] == n){
    //             i++;
    //             n++;
    //             ans++;
    //         }else{
    //             n++;
    //             ans++;
    //             count++;
    //         }
    //     }
    //     return ans;
    // }

    //二分法   对于每个元素 a[i] ，我们都可以唯一确定到第 i 个元素为止缺失的元素数量为 a[i]-i-1
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }

        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] - mid >= k + 1){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        return k + l;
    }
}
