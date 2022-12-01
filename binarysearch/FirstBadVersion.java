package binarysearch;

public class FirstBadVersion {
    // leetcode 278 simple 2022/12/1
    // 有问题，在特定的用列下会超时，还没有找到超时的规律
    public int firstBadVersion(int n) {
        int left = 0,right = n + 1;
        while(left + 1 != right) {
            int mid = (left + right) >> 1;
            if (isBadVersion(mid)) {
                left = mid;
            }else {
                right = mid;
            }
        }
        return right;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
