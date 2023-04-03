package array;

public class PreviousPermutationWithOneSwap {
    // leetcode 1053 medium 2023/4/3
    // 这道题目的关键是 按字典序排列小于 A 的最大可能排列， 那么有
    // 对当前序列进行逆序查找，找到第一个降序的位置 i，使得 A[i]>A[i+1]A[i]>A[i+1]
    // 寻找在 A[i] 右方最靠近i且小于 A[i] 的最大的数字 A[j]

    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        int curMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]){
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] > arr[j]){
                        hasResult = true;
                        if (arr[j] > curMax) {
                            curMax = arr[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    swap(arr,i,index);
                    return arr;
                }
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
